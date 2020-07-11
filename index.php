<!DOCTYPE html>
<html>
  <head>
    <link href="https://fonts.googleapis.com/css2?family=Inconsolata:wght@300&display=swap" rel="stylesheet">
    <link type="text/css" href="style.css" rel="stylesheet" />
    <script type="text/javascript" src="script.js"></script>
    <title>App Generator</title>
  </head>
  <body onload="pageSize()" onresize="pageSize()">
    <div id="page">
      <div id="phone">
      </div>
      <div id="square">
        <h1>App Generator</h1>
        <div id="settings">
        </div>
      </div>
    </div>
  </body>
</html>

<?php
  exec("javac *.java");
  $code = shell_exec("java Main");
  // echo $code;
?>
