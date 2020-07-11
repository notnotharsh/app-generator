<!DOCTYPE html>
<html>
  <head>
    <title>comfortably numb</title>
  </head>
  <body>
    <h1>hello</h1>
    <h2>is there anybody in there?</h2>
    <h3>just nod if you can hear me</h3>
    <?php
      exec("javac *.java");
      $code = shell_exec("java Main");
      echo $code;
    ?>
  </body>
</html>
