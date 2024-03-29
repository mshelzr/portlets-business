/*
 ---
 description: Date picker that works in an iframe and allows for keyboard navigation.

 license: MIT-style

 authors:
 - Micah Nolte

 requires:
 - core:1.2.4
 - core:1.2.4/Array
 - core:1.2.4/String
 - /MooTools.More
 - /Date
 - /IFrameShim

 provides: [SlimPicker]

 ...
 */
var SlimPicker = new Class({
  Implements: [Options, Events],
  options: {
    containerClass: 'sp_container',   // This will always start at the top left of the input's location.
    calendarClass: 'sp_cal',          // Use this to alter the placement of the calendar in the CSS.
    hoverClass: 'sp_hover',           // If using the keyboard, this gets moved around the calendar by arrow keys.
    selectedClass: 'sp_selected',     // The date picked up from what was in the input field.
    todayClass: 'sp_today',           // Always just on today. The sp_selected usually overrides this.
    emptyClass: 'sp_empty',           // Placed on the <td> of a date with no day in it.
    dayClass: 'sp_day',               // Placed on the <td> with a day in it.
    monthClass: 'sp_month',           // On the dropdown for month.
    yearClass: 'sp_year',             // On the dropdown for year.

    fadeDuration: 200,                // How fast the calendar fades in and out.
    hideDelay: 500,                   // How long to wait to close the calendar after the mouse leaves.
    extendedDelay: 5000,              // After a dropdown is open, how long to wait before we give up and hide the calendar.
    showMonth: true,                  // Add the dropdown select for month.
    showYear: true,                   // Add the dropdown select for year.
    autoHide: true,                   // Without this, it won't set a timer to hide the calendar whenever you move away.
    forceDocBoundary: true,           // If the calendar would be shown outside the document, then flip the direction it shows up.
    destroyWhenDone: false,           // After selecting a date, true will remove the calendar completely, and false just hides it.
    // Settings for the calendar itself
    dayChars: 1,
    monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
    dayNames: ['Domingo','Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
    dayNamesShort: ['Dom','Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab'],
    format: 'dd/mm/yyyy',                                          // How the output looks after selection
    yearStart: (new Date().getFullYear() - 5),                     // Default starting year for dropdown options is 5 years ago
    yearRange: 10,                                                 // Show a 10 year span
    yearOrder: 'asc',                                              // Counting up in years
    startDay: 1                      // 1 = week starts on Monday, 7 = week starts on Sunday
    //positionleft: 35
  },
  initialize: function(el, options) {
    // There are two ways to set the options on the fly.
    // They can be passed in when this class is started up.
    this.setOptions(options);
    // Saving the input field
    this.input = $(el);
    // Any options in the alt attribute will overwrite ones passed into the initializer
    if (this.input.get('alt')) this.setOptions(JSON.decode(this.input.get('alt')));
    // Saving the document, in case it's in a frame window.
    this.doc = this.input.ownerDocument;
    this.docSize = this.doc.getScrollSize();
    // This sets several instance variables
    this.setCurrentDate();
    // Adding onClick and onFocus events
    this.input.addEvent('click', this.show.bind(this)).addEvent('focus', this.show.bind(this));
    // Watch the keyboard clicks. Since we can't remove this later, just add it once.
 	
	// this.doc.addEvent((.trident || .webkit) ? 'keydown' : 'keypress', this.checkKeys.bindWithEvent(this));
   	this.doc.addEvent('keypress', this.checkKeys.bindWithEvent(this));

    // Setting the state of the calendar as off.
    this.open = false;
    this.dropDownShowing = false;
  },
  setCurrentDate: function() {
    var inputValue = this.input.get('value');
    this.now = new Date();
    if (inputValue != '' &&  inputValue != 'dd/mm/aaaa' ) {
      this.current = new Date.parse(inputValue);
    } else {
      this.current = this.now;
    }
    // The date to show on the calendar
    this.currentYear = this.calendarYear = this.current.getFullYear();
    this.currentMonth = this.calendarMonth = this.current.getMonth();
    this.currentDay = this.current.getDate();
    // Keeping track of today to show on the calendar
    this.nowYear = this.now.getFullYear();
    this.nowMonth = this.now.getMonth();
    this.nowDay = this.now.getDate();
  },
  show: function() {
    if (this.open) return true;
    this.open = true;
    if (!this.container) this.create();
    this.draw();
    if (this.shim) this.shim.show();
    this.container.set('tween', {duration: this.options.fadeDuration}).fade(1);
  },
  close: function() {
    this.open = false;
    this.dropDownShowing = false;
    this.removeTimer();
    if (!this.container) return false;
    this.container.set('tween', {onComplete: this.destroyCal.bind(this)}).fade(0);
    if (this.shim) this.shim.hide();
  },
  destroyCal: function() {
    if (!this.options.destroyWhenDone) return true;
    this.container.destroy();
    this.container = false;
  },

  checkKeys: function(e) {
    if (!this.open) {
      return true;
    }
    var availableKeys = ['tab', 'esc', 'enter', 'up', 'down', 'left', 'right'];
    if (availableKeys.contains(e.key)) {
      switch (e.key) {
        // If there's a selected day, use that one.
        case 'enter':
          e.stop();
          this.tryHoverSelect();
          break;
        case 'esc':
          e.stop();
          this.close();
          break;
        // Change the focus?
        case 'tab':
          // On a shift-tab, reverse direction
          this.close();
//					this.moveFocus(e.shift);
          break;
        // The rest are the directions
        default:
          e.stop();
          this.moveSelection(e.key);
          break;
      }
    }
  },
  tryHoverSelect: function() {
    var link = this.hoveredDay.getElement('a');
    if (link) {
      this.useSelection(link);
    }
  },
  useSelection: function(el) {
    if (!el) return false;
    var dateArray = el.get('href').split('#')[1].split('|');
    this.input.value = this.formatValue(dateArray[0], dateArray[1], dateArray[2]);
    this.close();
  },
  // Keyboard arrow keys. Wraps around horizontally, but will access the dropdowns and wrap if you move up.
  moveSelection: function(direction) {
    switch (direction) {
      case 'up':
        this.hoverRow = this.hoverRow - 1;
        if (this.hoverRow < 1) {
          this.hoverRow = this.calendarRows;
        }
        break;
      case 'down':
        this.hoverRow = this.hoverRow + 1;
        if (this.hoverRow > this.calendarRows) {
          this.hoverRow = 1;
        }
        break;
      case 'left':
        // Row 0 is the dropdown row
        this.hoverCol = this.hoverCol - 1;
        if (this.hoverCol < 0) {
          this.hoverCol = 6;
        }
        break;
      case 'right':
        this.hoverCol = this.hoverCol + 1;
        if (this.hoverCol > 6) {
          this.hoverCol = 0;
        }
        break;
    }
    this.markHoveredDay();
  },

  // Just applies whatever is saved as the hovered day to the calendar.
  // If there aren't that many rows, it pushes it up until there is one.
  markHoveredDay: function() {
    if (this.hoverRow > this.calendarRows) this.hoverRow = this.calendarRows;
    // Row 0 is the dropdown selector one.
    if (this.hoverRow == 0) {
      // Since there's only two, either left or right
      this.calendar.getElements('.'+this.options.hoverClass).removeClass(this.options.hoverClass);

    } else {
      var row = this.calendar.getElements('tbody tr')[this.hoverRow];
      this.hoveredDay = row.getElements('td')[this.hoverCol];
      this.calendar.getElements('.'+this.options.hoverClass).removeClass(this.options.hoverClass);
      this.hoveredDay.addClass(this.options.hoverClass);
    }
  },
  // 
  // If both are showing, this just switches which one it is.
  // If there's one, it gives it focus.
  moveAndFocusDropdown: function() {
    // Make sure at lease one dropdown is there before doing anything.
    if (!this.options.showMonth && !this.options.showYear) {
      return true;
    }
    // If nothing has been selected, pick the first one.
    if (!this.hoveredDropdown) {
      this.hoveredDropdown = 0;
      // Both dropdowns need to be showing for this to do anything
    } else if (this.options.showMonth && this.options.showYear) {

    }
    this.thead.getElement('select')[this.hoveredDropdown].focus();
  },
  
  moveFocus: function(reverse) {
    // Should it start on the month or year dropdown, or the calendar itself?
    // After tabbing away, should it just close the calendar, or determine the next form field?
    // Should there by a highlighting to show what has focus?
  },
  create: function() {
    // Don't need to create it if it already exists.
    if (this.container) {
      return false;
    }
    // Prevent cursor in input field.
    this.input.set('readonly', 'true').set('autocomplete', 'off');
    // The "new Element" doesn't work in frames in IE, so creating it old-school.
    this.container = $(this.doc.createElement('div'));
    // Adding it to the bottom of the document. This allows it to overlay anything we need it to.
    this.container
        .addClass(this.options.containerClass)
        .setStyle('opacity', 0)
        .inject(this.doc.body);
    // Set the transparent container at the top left of the input field.
    this.position();
    // Add a timer for if you move your mouse away from it
    if (this.options.autoHide) {
      this.container.addEvent('mouseenter', this.removeTimer.bind(this)).addEvent('mouseleave', this.addTimer.bind(this));
    }
    this.calendar = $(this.doc.createElement('div'));
    this.calendar.addClass(this.options.calendarClass).inject(this.container);
    this.shim = new IframeShim(this.calendar);
  },
  draw: function() {
    var str = '<table>';
    // Making dropdowns
    if (this.options.showMonth || this.options.showYear) {
      str += this.addMonthYearDropdowns();
    }
    str += '<tbody>';
    var calendarDate = new Date();
    calendarDate.setFullYear(this.calendarYear, this.calendarMonth, 1);
    var currentDay = (1-(7+calendarDate.getDay()-this.options.startDay)%7);
    this.lastDayMonth = this.getLastDayMonth(this.currentYear,this.currentMonth);
    this.lastDayMonthPrevious = this.getLastDayMonthPrevious(this.currentYear,this.currentMonth);
    str += '<tr>';
    this.options.dayNames.each( function(name, index) {
      str += '<th>' + this.options.dayNamesShort[(this.options.startDay+index)%7] + '</th>';
    }, this);
    str += '</tr>';
    var row = 0;
    var dayMonthNext = 0;
    var dayMonthPrevious = this.lastDayMonthPrevious - (currentDay * -1);
    //while (currentDay <= this.options.daysInMonth[this.calendarMonth]){
    //while ((currentDay <= this.lastDayMonth) && (row <= 6) ){
    while (row < 6 ){
    row += 1;
    str += '<tr>';
    for (var i = 0; i < 7; i++){
      if ((currentDay <= this.lastDayMonth) && (currentDay > 0) && (row <= 6) ){
      str += '<td><a href="#' + this.calendarYear + '|' + (parseInt(this.calendarMonth) + 1) + '|' + currentDay + '" class="' + this.options.dayClass;
      // Show the currently selected day
        if ( (currentDay == this.currentDay) && (this.calendarMonth == this.currentMonth) && (this.calendarYear == this.currentYear) ) {
          str += ' ' + this.options.selectedClass;
          this.hoverRow = row;
          this.hoverCol = i;
        }
        if ( (currentDay == this.nowDay) && (this.calendarMonth == this.nowMonth) && (this.calendarYear == this.nowYear) ) {
          str += ' ' + this.options.todayClass;
        }
      str += '">' + currentDay + '</a></td>';
      } else {
        if(row > 4){
          dayMonthNext += 1;
          str += '<td class="' + this.options.emptyClass + '"> '+ dayMonthNext + ' </td>';
        }else{
          str += '<td class="' + this.options.emptyClass + '"> '+ dayMonthPrevious +'</td>';
          dayMonthPrevious += 1;
        }
      }
      currentDay++;
    }
    str += '</tr>';
    }
    str += '</tbody></table>';
    this.calendar.set('html', str);
    this.calendarRows = row;
    this.position();
    this.addCalendarEvents();
  },

    addMonthYearDropdowns: function () {
      var str = '';
      if (this.options.showMonth) {
      str = '<div class="calendar-data-cont month"> \
                <div class="calendar-title">\
                  <div id="previous"></div>\
                  <div class="titleMonth">'+ this.options.monthNames[this.currentMonth] +'</div>\
                   <div id="next"></div>\
                </div>\
             </div>';
      }
      if (this.options.showYear) {
      str += '<div class="calendar-data-cont year">\
              <div class="calendar-title">\
                <div class="titleYear"> '+ this.currentYear +' </div>\
                <div class="content-btn">\
                  <div id="up">&nbsp;</div>\
                  <div id="down">&nbsp;</div>\
                </div>\
              </div>\
            </div>';
      }
      if (this.options.showMonth && this.options.showYear ) {
        str ='<div class="calendar-controls">'+ str +'</div>';
      }
      str = '<thead><tr><th colspan="7">' + str + '</th></tr></thead>';
      return str;
    },
    addCalendarEvents: function() {
      this.tbody = this.calendar.getElement('tbody');
      this.tbody.addEvent('click', this.calendarClick.bindWithEvent(this));
      this.thead = this.calendar.getElement('thead');
      if (this.options.showYear) {
        this.yearUp = this.calendar.getElement('div#up');
        this.yearDown = this.calendar.getElement('div#down');
        this.yearUp.addEvent('focus', this.markDropdownShowing.bind(this)).addEvent('click', this.changedYearUp.bind(this));
        this.yearDown.addEvent('focus', this.markDropdownShowing.bind(this)).addEvent('click', this.changedYearDown.bind(this));
      }
      if (this.options.showMonth) {
        this.monthNext = this.calendar.getElement('div#next');
        this.monthPrevious = this.calendar.getElement('div#previous');
        this.monthNext.addEvent('focus', this.markDropdownShowing.bind(this)).addEvent('click', this.changedMonthNext.bind(this));
        this.monthPrevious.addEvent('focus', this.markDropdownShowing.bind(this)).addEvent('click', this.changedMonthPrevious.bind(this));
      }
    },
  position: function() {
    if (!this.input || !this.container) return false;
    var coords = this.input.getCoordinates();

    this.container.setStyles({
      height: coords.height,
      width: coords.width,
      left: coords.left - 35,
      top: coords.top
    });

    if (this.calendar && this.options.forceDocBoundary) this.checkDocBoundary();
    if (this.shim) this.shim.position();
  },
  checkDocBoundary: function() {
    var calSize = this.calendar.getCoordinates();
    if (calSize.right > this.docSize.x) {
      this.calendar.setStyles({left: 'auto', right: 0});
    }
    if (calSize.bottom > this.docSize.y) {
      this.calendar.setStyles({top: 'auto', bottom: 0});
    }
    if (calSize.left < 0) {
      this.calendar.setStyles({left: 0, right: 'auto'});
    }
    if (calSize.top < 0) {
      this.calendar.setStyles({top: 0,bottom: 'auto'});
    }
  },
  markDropdownShowing: function() {
    this.dropDownShowing = true;
    this.extendedTimer = this.close.bind(this).delay(this.options.extendedDelay);
  },
  changedMonthPrevious:function(){
    if(this.currentMonth <= 11 && this.currentMonth > 0 ){
      this.currentMonth = parseInt(this.currentMonth) - 1;
      this.selectChanged();
    }
  },
  changedMonthNext:function(){
    if(this.currentMonth < 11 && this.currentMonth >= 0){
        this.currentMonth = parseInt(this.currentMonth) + 1;
        this.selectChanged();
    }
  },
  changedYearUp:function(){
       this.currentYear = parseInt(this.currentYear) + 1;
       this.selectChanged();
  },
  changedYearDown:function(){
       this.currentYear = parseInt(this.currentYear) - 1;
       this.selectChanged();
  },
  selectChanged: function() {
    this.dropDownShowing = false;
    clearTimeout(this.extendedTimer);
    this.calendarMonth = this.currentMonth;
    this.calendarYear = this.currentYear;
    this.draw();
  },
  // A click on the <tbody> happened, so go up until you get a link, or hit the top.
  calendarClick: function(e) {
    var target = $(e.target);
    var target_tag = target.get('tag');
    while((target_tag != 'a') && (target_tag != 'input') && (target_tag != 'html')){
      target = target.getParent();
      if (!target) return;
      target_tag = target.get('tag');
    }
    if (target.hasClass(this.options.dayClass)) {
      e.stop();
      this.useSelection(target);
    }
  },
  addTimer: function() {
    // Checks the "dropDownShowing" in case they have a dropdown open
    if (!this.dropDownShowing) this.timer = this.close.bind(this).delay(this.options.hideDelay);
  },
  removeTimer: function() {
    clearTimeout(this.timer);
  },
  formatValue: function(year, month, day) {
    var dateStr = '';
    if (day < 10) day = '0' + day;
    if (month < 10) month = '0' + month;
    dateStr = this.options.format.replace( /dd/i, day ).replace( /mm/i, month ).replace( /yyyy/i, year );
    this.currentYear = this.calendarYear = year;
    this.currentMonth = this.calendarMonth = '' + (month - 1) + '';
    this.currentDay = day;
    return dateStr;
  },
  getLastDayMonthPrevious:function(year, month){
      month = month - 1;
      if(month == 0){
          month = 11;
          year =  year - 1;
      }
      return this.getLastDayMonth(year, month);
  },
  getLastDayMonth:function(year, month){
    var lastDayUnix = Math.round(new Date(year, month + 1 , 1).getTime()/1000.0 ) - 86400 ;
    var lastDay = new Date(lastDayUnix * 1000).getDate();
    return lastDay;
  }
});
/**
 * adds the now deprecated function bindWithEvent
 * http://groups.google.com/group/mootools-users/browse_thread/thread/9f84338da6dcdb18
 * 
 * @author: Tuxosaurus
 * @since: 2012-03-15
 */
Function.implement({
  bindWithEvent: function(bind, args){
  var self = this;
  if (args != null) args = Array.from(args);
  return function(event){
    return self.apply(bind, (args == null) ? arguments : [event].concat(args));
  };
}
});