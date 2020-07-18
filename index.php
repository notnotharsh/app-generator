<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="favicon.ico" type="image/x-icon" />
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
        <h1>Scouting App Generator</h1>
        <div id="settings">
          <div id="bar">
            <div id="tabs">
            </div>
            <div id="bottom">
              <div id="plus">
                <p>Add Page</p>
              </div>
              <div id="state">
                <p>Save/Load State</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
<?php
  exec("javac java/*.java");
  $code = shell_exec("java -cp java Main");
  # echo $code;
?>
