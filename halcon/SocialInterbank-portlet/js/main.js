twitterFetcher.fetch('417799429546983424', '', 1, true, true, true, '', false, handleTweets, false);


function handleTweets(tweets){
    if(typeof $ !== "undefined"){
          $('ultimoTweet').set('html',tweets[0]);
          tweet = $('ultimoTweet').getElement('p.tweet');
          tweet.inject($('showTweet'));
    }else{   
       var ultimoTweet,showTweet;
      
          ultimoTweet = document.getElementById("ultimoTweet");
          showTweet = document.getElementById("showTweet");
          ultimoTweet.innerHTML = tweets[0];
          tweet = ultimoTweet.getElementsByTagName("p")[0];
          showTweet.appendChild(tweet);
    }
}
