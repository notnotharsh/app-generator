<!DOCTYPE html>
<html>
  <head>
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
          <?php
            exec("javac java/*.java");
            $code = shell_exec("java -cp java Main");
            # echo $code;
          ?>
        </div>
      </div>
    </div>
  </body>
</html>
