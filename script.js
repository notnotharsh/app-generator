function pageSize() {
  var width = innerWidth;
  var height = innerHeight;
  if (width / height >= 7/4) {
    document.getElementById("page").style.height = innerHeight + "px";
    document.getElementById("page").style.width =  (7/4 * innerHeight) + "px";
  } else {
    document.getElementById("page").style.width = innerWidth + "px";
    document.getElementById("page").style.height =  (4/7 * innerWidth) + "px";
  }
}
