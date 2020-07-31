var appState = {title: "", instructions: [""], instruction: 0, pages: [], page: 0};

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
  constructDetails(tab);
}

function refresh() {
  tab = appState.page;
  constructDetails(tab);
}

function constructDetails(tab) {
  if (tab == 0) {
    constructDetailsGeneral();
  } else {
    document.getElementById("details").innerHTML = "";
  }
  banNewLine();
  colorHeightLoaders();
  colorSliders();
}

function constructDetailsGeneral() {
  var code = "<div class=\"heightloader\" style=\"height: 15%\"><p>App Title: <input id=\"title\" class=\"edit\" onfocusout=\"saveData(false, true)\" value=\"\" /></div><div class=\"heightloader\" style=\"height: 75%\"><p>Instructions</p><textarea id=\"instructions\" onfocusout=\"saveData(false, false)\"></textarea></div><div class=\"heightloader\" style=\"height: 10%\"><span class=\"slider instruction\"><span class=\"material-icons\">chevron_left</span><span class=\"material-icons\" onclick=\"addSlidePage('root', 'instruction')\">add</span><span class=\"material-icons\">chevron_right</span></span></div>";
  document.getElementById("details").innerHTML = code;
  document.getElementById("title").value = appState.title;
  switchSlider("root", "instruction", 0);
}

function saveData(isPage, param) {
  if (!isPage) {
    if (param) {
      appState.title = document.getElementById("title").value;
    } else {
      appState.instructions[appState.instruction] = document.getElementById("instructions").value;
    }
  }
}

function banNewLine() {
  var editables = document.getElementsByClassName("edit");
  for (var i = 0; i < editables.length; i++) {
    editables[i].addEventListener("keydown", (evt) => {
      if (evt.keyCode === 13) {
        evt.preventDefault();
      }
    });
  }
}

function colorHeightLoaders() {
  var heightloaders = document.getElementsByClassName("heightloader");
  for (var i = 0; i < heightloaders.length; i++) {
    if (i % 2 == 1) {
      heightloaders[i].style.backgroundColor = "#282828";
    }
  }
}

function colorSliders() {
  var sliders = document.getElementsByClassName("slider");
  for (var i = 0; i < sliders.length; i++) {
    var num = appState[sliders[i].classList.item(1)];
    var length = appState[sliders[i].classList.item(1) + "s"].length;
    if (num == 0) {
      sliders[i].getElementsByTagName("span")[0].classList.add("disabled");
      sliders[i].getElementsByTagName("span")[0].setAttribute("onClick", "switchSlider('root', '" + sliders[i].classList.item(1) + "', " + (num) + ")");
    } else {
      sliders[i].getElementsByTagName("span")[0].classList.remove("disabled");
      sliders[i].getElementsByTagName("span")[0].setAttribute("onClick", "switchSlider('root', '" + sliders[i].classList.item(1) + "', " + (num - 1) + ")");
    }
    if (num == length - 1) {
      sliders[i].getElementsByTagName("span")[2].classList.add("disabled");
      sliders[i].getElementsByTagName("span")[2].setAttribute("onClick", "switchSlider('root', '" + sliders[i].classList.item(1) + "', " + (num) + ")");
    } else {
      sliders[i].getElementsByTagName("span")[2].classList.remove("disabled");
      sliders[i].getElementsByTagName("span")[2].setAttribute("onClick", "switchSlider('root', '" + sliders[i].classList.item(1) + "', " + (num + 1) + ")");
    }
  }
}

function switchSlider(dir, ID, page) {
  if (dir === "root") {
    appState[ID] = page;
    document.getElementById(ID + "s").value = appState[ID + "s"][page];
    colorSliders();
  } else {
    appState[dir][ID] = page;
    document.getElementById(ID + "s").value = appState[dir][ID + "s"][page];
    colorSliders();
  }
}

function addSlidePage(dir, ID) {
  if (dir === "root") {
    appState[ID + "s"].splice(appState[ID] + 1, 0, "");
    switchSlider(dir, ID, appState[ID] + 1);
  } else {
    appState[dir][ID + "s"].splice(appState[dir][ID] + 1, 0, "");
    switchSlider(dir, ID, appState[dir][ID] + 1);
  }
}
