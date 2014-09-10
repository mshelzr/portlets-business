<%--
/**
 * @author Infonet Consulting S.A.C.
25/10/2012
portlet utilizando el api de twitter
*/
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<script async type="text/javascript" src="/SocialInterbank-portlet/js/twitter.js"></script>
<script async type="text/javascript" src="/SocialInterbank-portlet/js/main.js"></script>

<portlet:defineObjects />

 

<!--SOCIAL-->
  <div class="social">  
    <!--social-pie-->
    <div class="social-pie">
      <div class="twitter-interbank"> <em class="t-icono"></em>
        <p class="bold">Twitter:</p>
        <p>@interbank</p>
        <div class="both"></div>
      </div>
      <div id="showTweet" class="tweet">  

      </div>
      <div class="siguenos">
        <p>También síguenos en</p>
        <div id="socials" class="margnsoc">
          <ul>
            <li><a href="https://www.facebook.com/InterbankPeru" title="Interbank en Facebook" class="soc-fb" target="_blank">Interbank en Facebook</a></li>
            <li><a href="https://twitter.com/interbank" title="Interbank en Twitter" class="soc-twitter" target="_blank">Interbank en Twitter</a></li>
            <li><a href="https://www.youtube.com/user/InterbankDigital" title="Interbank en Youtube" class="soc-youtb" target="_blank">Interbank en Youtube</a></li>
          </ul>
        </div>
        <!-- <a href="#" title="Youtube"><em class="youtube"></em></a> <a href="#" title="Twitter"><em class="twitter"></em></a> <a href="#" title="Facebook" ><em class="facebook"></em></a>   --> 
      </div>
    </div>
  </div> 
  
  
  <div id="ultimoTweet" style="display:none;"></div>