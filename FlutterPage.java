import java.util.ArrayList;
public class FlutterPage {
  public String pageName;
  public ArrayList<String[]> variableList;
  public FlutterPage(String pageName, ArrayList<String[]> variableList) {
    this.pageName = pageName;
    this.variableList = variableList;
  }
  public String assembleString() {
    String wholeFile = "";
    wholeFile += "import 'dart:math';\nimport 'package:flutter/material.dart';\nimport 'package:flushbar/flushbar.dart';\nimport 'useful.dart';\n\n";
    wholeFile += String.format("class %s extends StatefulWidget {\n\t%s ({Key key}) : super(key: key);\n\t@override\n\t%sState createState() => %sState();\n};\n\n", pageName, pageName, pageName, pageName);
    wholeFile += String.format("class %sState extends State<%s> {\n\tGlobalKey scaffold = GlobalKey();\n", pageName, pageName);
    for (String[] i : variableList) {
      String defaultVal;
      if (i[0].equals("int")) {
        defaultVal = "0";
      } else {
        defaultVal = "''";
      }
      wholeFile += String.format("\t%s %s = %s;\n", i[0], i[1], defaultVal);
    }
    for (String[] i: variableList) {
      if (i[2].equals("req")) {
        wholeFile += String.format("\tBoolean %sRed = Boolean(false);\n", i[1]);
      }
    }
    for (String[] i: variableList) {
      if (i[3].equals("text")) {
        wholeFile += String.format("\tTextEditingController %sController = TextEditingController();\n", i[1]);
      }
    }
    return wholeFile;
  }
}
