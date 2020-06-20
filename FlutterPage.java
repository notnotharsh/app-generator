import java.util.ArrayList;
public class FlutterPage {
  public String pageName;
  public ArrayList<int[]> variableList;
  public FlutterPage(pageName, variableList) {
    this.pageName = pageName;
    this.variableList = variableList;
  }
  public String assembleString() {
    String wholeFile = "";
    wholeFile += "import 'dart:math';\nimport 'package:flutter/material.dart';\nimport 'package:flushbar/flushbar.dart';\nimport 'useful.dart';\n\n";
    String stateful = String.format("class %s extends StatefulWidget {\n\t%s ({Key key}) : super(key: key);\n\t@override\n\t%sState createState() => %sState();\n};\n\n", pageName, pageName, pageName, pageName);
  }
}
