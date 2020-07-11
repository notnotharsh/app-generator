function pageSize() {
  var width = innerWidth;
  var height = innerHeight;
  console.log(width / height >= 14/9);
  if (width / height >= 14/9) {
    document.getElementById("page").style.height = innerHeight + "px";
    document.getElementById("page").style.width =  (14/9 * innerHeight) + "px";
  } else {
    document.getElementById("page").style.width = innerWidth + "px";
    document.getElementById("page").style.height =  (9/14 * innerWidth) + "px";
  }
}
