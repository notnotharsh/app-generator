function pageSize() {
  var width = document.body.clientWidth;
  var height = document.body.clientHeight;
  if (width / height >= 7/4) {
    document.getElementById("page").style.height = document.body.clientHeight + "px";
    document.getElementById("page").style.width =  (7/4 * document.body.clientHeight) + "px";
  } else {
    document.getElementById("page").style.width = document.body.clientWidth + "px";
    document.getElementById("page").style.height =  (4/7 * document.body.clientWidth) + "px";
  }
}

function controlTabs() {
  var tabs = document.getElementById("tabs");
  var length = tabs.childElementCount;
  var percent = 100 / length;
  for (var i = 0; i < length; i++) {
    tabs.getElementsByClassName("tab")[i].style.height = percent.toString() + "%";
  }
}

function tabListeners() {
  var tabs = document.getElementsByClassName("tab");
  for (var i = 0; i < tabs.length; i++) {
    tabs[i].setAttribute("onclick", "switchTabs(" + i + ")")
  }
}

function switchTabs(tab) {
  var tabs = document.getElementsByClassName("tab");
  if (tab == tabs.length - 2) {
    for (var j = 0; j < tabs.length; j++) {
      if (j != tab) {
        tabs[j].classList.remove("clicked");
      }
    }
    document.getElementById("tabs").innerHTML += "<div class=\"tab clickable clicked\"><p>P" + (tabs.length - 2) + "</p></div>";
    controlTabs();
    tabListeners();
  } else {
    for (var j = 0; j < tabs.length; j++) {
      if (j == tab) {
        tabs[j].classList.add("clicked");
      } else {
        tabs[j].classList.remove("clicked");
      }
    }
  }
}
