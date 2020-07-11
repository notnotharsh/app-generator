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
    wholeFile += String.format("import 'dart:math';\nimport 'package:flutter/material.dart';\nimport 'package:flushbar/flushbar.dart';\nimport 'useful.dart';\n\nclass %s extends StatefulWidget {\n\t%s ({Key key}) : super(key: key);\n\t@override\n\t%sState createState() => %sState();\n};\n\nclass %sState extends State<%s> {\n\tGlobalKey scaffold = GlobalKey();\n", pageName, pageName, pageName, pageName, pageName, pageName);
    for (String[] i : variableList) {
      String defaultVal;
      if (i[0].equals("int")) {
        defaultVal = "0";
      } else {
        defaultVal = "''";
      }
      wholeFile += String.format("\t%s %s = %s;\n", i[0], i[1], defaultVal);
    }
    for (String[] i : variableList) {
      if (i[2].equals("req")) {
        wholeFile += String.format("\tBoolean %sRed = Boolean(false);\n", i[1]);
      }
    }
    for (String[] i : variableList) {
      if (i[3].equals("text")) {
        wholeFile += String.format("\tTextEditingController %sController = TextEditingController();\n", i[1]);
      }
    }
    wholeFile += "\tString text = '';\n\tString ID = '';\n\tvoid reset() {\n\t\tsetState(() {\n";
    for (String[] i : variableList) {
      String defaultVal;
      if (i[0].equals("int")) {
        defaultVal = "0";
      } else {
        defaultVal = "''";
      }
      wholeFile += String.format("\t\t\t%s = %s;\n", i[1], defaultVal);
    }
    for (String[] i : variableList) {
      if (i[3].equals("text")) {
        wholeFile += String.format("\t\t\t%sController.clear();\n", i[1]);
      }
    }
    for (String[] i : variableList) {
      if (i[2].equals("req")) {
        wholeFile += String.format("\t\t\t%sRed.makeFalse();\n", i[1]);
      }
    }
    wholeFile += "\t\t});\n\t}\n\tFuture<void> resetDialog() async {\n\t\treturn showDialog<void>(\n\t\t\tcontext: context,\n\t\t\tbarrierDismissible: false,\n\t\t\tbuilder: (BuildContext context) {\n\t\t\t\treturn AlertDialog(\n\t\t\t\t\ttitle: Text('Reset match?'),\n\t\t\t\t\tcontent: SingleChildScrollView(\n\t\t\t\t\t\tchild: ListBody(\n\t\t\t\t\t\t\tchildren: <Widget>[\n\t\t\t\t\t\t\t\tText('All unsubmitted objective scouting information will be lost.'),\n\t\t\t\t\t\t\t],\n\t\t\t\t\t\t),\n\t\t\t\t\t),\n\t\t\t\t\tactions: <Widget>[\n\t\t\t\t\t\tFlatButton(\n\t\t\t\t\t\t\tchild: Text('Yes'),\n\t\t\t\t\t\t\tonPressed: () {\n\t\t\t\t\t\t\t\tNavigator.of(scaffold.currentContext).pop();\n\t\t\t\t\t\t\t\treset();\n\t\t\t\t\t\t\t},\n\t\t\t\t\t\t),\n\t\t\t\t\t\tFlatButton(\n\t\t\t\t\t\t\tchild: Text('No'),\n\t\t\t\t\t\t\tonPressed: () {\n\t\t\t\t\t\t\t\tNavigator.of(scaffold.currentContext).pop();\n\t\t\t\t\t\t\t},\n\t\t\t\t\t\t),\n\t\t\t\t\t],\n\t\t\t\t);\n\t\t\t},\n\t\t);\n\t}\n\tFuture<void> submitDialog() async {\n\t\treturn showDialog<void>(\n\t\t\tcontext: scaffold.currentContext,\n\t\t\tbarrierDismissible: false,\n\t\t\tbuilder: (BuildContext context) {\n\t\t\t\treturn AlertDialog(\n\t\t\t\t\ttitle: Text('Submit match?'),\n\t\t\t\t\tcontent: SingleChildScrollView(\n\t\t\t\t\t\tchild: ListBody(\n\t\t\t\t\t\t\tchildren: <Widget>[\n\t\t\t\t\t\t\t\tText('You will not be able to change submitted scouting data.'),\n\t\t\t\t\t\t\t],\n\t\t\t\t\t\t),\n\t\t\t\t\t),\n\t\t\t\t\tactions: <Widget>[\n\t\t\t\t\t\tFlatButton(\n\t\t\t\t\t\t\tchild: Text('Yes'),\n\t\t\t\t\t\t\tonPressed: () async {\n\t\t\t\t\t\t\t\tNavigator.of(scaffold.currentContext).pop();\n\t\t\t\t\t\t\t\tbool flag = true;\n\t\t\t\t\t\t\t\tsetState(() {\n\t\t\t\t\t\t\t\t\tList<String> criteria = [";
    for (int i = 0; i < variableList.size(); i++) {
      if (variableList.get(i)[2].equals("req")) {
        if (i < variableList.size() - 1) {
          wholeFile += String.format("%s, ", variableList.get(i)[1]);
        } else {
          wholeFile += variableList.get(i)[1];
        }
      }
    }
    wholeFile += "];\n\t\t\t\t\t\t\t\t\tList<String> bools = [";
    for (int i = 0; i < variableList.size(); i++) {
      if (variableList.get(i)[2].equals("req")) {
        if (i < variableList.size() - 1) {
          wholeFile += String.format("%sRed, ", variableList.get(i)[1]);
        } else {
          wholeFile += variableList.get(i)[1] + "Red";
        }
      }
    }
    wholeFile += "];\n\t\t\t\t\t\t\t\t\tfor (int i = 0; i < criteria.length; i++) {\n\t\t\t\t\t\t\t\t\t\tif (criteria[i] == '') {\n\t\t\t\t\t\t\t\t\t\t\tflag = false;\n\t\t\t\t\t\t\t\t\t\t\tbools[i].makeTrue();\n\t\t\t\t\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\t\t\t\t\tbools[i].makeFalse();\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t});\n\t\t\t\t\t\t\t\tif (flag) {\n\t\t\t\t\t\t\t\t\tmatch = match.toUpperCase();\n\t\t\t\t\t\t\t\t\tbool quals = false;\n\t\t\t\t\t\t\t\t\tif (((!(match[0] == 'S')) && (!(match[0] == 'F'))) && (!((match[0] == 'Q') && (match[1] == 'F')))) {\n\t\t\t\t\t\t\t\t\t\tquals = true;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\tif ((match[0] != 'Q') && (quals == true)) {\n\t\t\t\t\t\t\t\t\t\tmatch = 'Q' + match;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\tint millis = DateTime.now().millisecondsSinceEpoch;\n\t\t\t\t\t\t\t\t\tString complete = '";
    for (String[] i : variableList) {
      wholeFile += String.format("$%s|", i[1]);
    }
    wholeFile += String.format("\n\t\t\t\t\t\t\t\t\t\twriteText('%sLogs', '%sLog.txt', complete, true)$millis|}';\n\t\t\t\t\t\t\t\t\tint status = await makeRequest(ID, complete);\n\t\t\t\t\t\t\t\t\tif (status == 200) {\n\t\t\t\t\t\t\t\t\t\tFlushbar(\n\t\t\t\t\t\t\t\t\t\t\ttitle: 'Send successful',\n\t\t\t\t\t\t\t\t\t\t\tmessage: 'Match sent to spreadsheet',\n\t\t\t\t\t\t\t\t\t\t\tduration: Duration(seconds: 2),\n\t\t\t\t\t\t\t\t\t\t\ticon: IconTheme(data: IconThemeData(color: Color(0xFF209020)), child: Icon(Icons.check_circle))\n\t\t\t\t\t\t\t\t\t\t).show(scaffold.currentContext);\n\t\t\t\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\t\t\t\tFlushbar(\n\t\t\t\t\t\t\t\t\t\t\ttitle: 'Save successful',\n\t\t\t\t\t\t\t\t\t\t\tmessage: 'Match backed up on file system',\n\t\t\t\t\t\t\t\t\t\t\tduration: Duration(seconds: 2),\n\t\t\t\t\t\t\t\t\t\t\ticon: IconTheme(data: IconThemeData(color: Color(0xFF209020)), child: Icon(Icons.check_circle))\n\t\t\t\t\t\t\t\t\t\t).show(scaffold.currentContext);\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\twriteText('%sLogs', '%sLog.txt', complete, true)\n\t\t\t\t\t\t\t\t\treset();\n\t\t\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\t\t\tFlushbar(\n\t\t\t\t\t\t\t\t\t\ttitle: 'Submit unsuccessful',\n\t\t\t\t\t\t\t\t\t\tmessage: 'Please fill out all required fields before submitting',\n\t\t\t\t\t\t\t\t\t\tduration: Duration(seconds: 2),\n\t\t\t\t\t\t\t\t\t\ticon: IconTheme(data: IconThemeData(color: Color(0xFF902020)), child: Icon(Icons.error))\n\t\t\t\t\t\t\t\t\t).show(scaffold.currentContext);\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t},\n\t\t\t\t\t\t),\n\t\t\t\t\t\tFlatButton(\n\t\t\t\t\t\t\tchild: Text('No'),\n\t\t\t\t\t\t\tonPressed: () {\n\t\t\t\t\t\t\t\tNavigator.of(scaffold.currentContext).pop();\n\t\t\t\t\t\t\t},\n\t\t\t\t\t\t),\n\t\t\t\t\t],\n\t\t\t\t);\n\t\t\t},\n\t\t);\n\t}\n\t@override\n\tvoid initState() {\n\t\treadText('settingsLogs', 'robot.txt').then((String txt) {\n\t\t\tsetState(() {\n\t\t\t\ttext = txt;\n\t\t\t});\n\t\t});\n\t\treadText('settingsLogs', '%sid.txt').then((String id) {\n\t\t\tsetState(() {\n\t\t\t\tID = id;\n\t\t\t});\n\t\t});\n\t\tsuper.initState();\n\t}", pageName, pageName, pageName, pageName, pageName);
    return wholeFile;
  }
}
