/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function appendComment(commentsList, content, date) { 
    var html = '<div class="message-comment">';
    html += "<div class=\"message-comment-date\">";
    html += date + ':';
    html += "</div>";
    html += content;
    html += '</div>';             
    commentsList.innerHTML += html;
}

function processCommentsData(responseXML) {
    var commentsList = document.getElementById("commentsList"); 
    commentsList.innerHTML = "";
    
    var comments = responseXML.getElementsByTagName("comments")[0];
    for (loop = 0; loop < comments.childNodes.length; loop++) {
        var comment = comments.childNodes[loop];
        var content = comment.getElementsByTagName("content")[0];
        var date = comment.getElementsByTagName("date")[0];

        appendComment(commentsList, content.childNodes[0].nodeValue, date.childNodes[0].nodeValue);
    }
}       

function processCommentResponse(req){
   if (req.readyState === 4) {
        if (req.status === 200) {
            processCommentsData(req.responseXML);
            document.getElementById("commTextId").value = "";
        }
    }         
}

function getXHR() {
    if (window.XMLHttpRequest) {
        return new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        return new ActiveXObject("Microsoft.XMLHTTP");
    }
}

function subminCommentRequest(){
  //Get the text value of the comment 
  var commText = document.getElementById("commTextId").value;
  if(commText === "")
  {
    alert("The comment is empty!");
  } else {
    //Get the message ID
    var msgId = document.getElementById("msgIdId").value;
    var url = "comm?msgId=" + encodeURI(msgId)+"&msgComment="+encodeURI(commText)+"&addComment="+encodeURI("true");
    var req = getXHR();
    req.onreadystatechange = function()  
      { processCommentResponse(req); };
    req.open("GET", url, true);
    req.send(null);
  }
}