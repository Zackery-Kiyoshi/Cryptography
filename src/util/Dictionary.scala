package util

import scala.io.StdIn.{readInt,readBoolean}
import scala.io.Source
import java.io.{FileReader, FileNotFoundException, IOException}

class Dictionary {
  var filename = "words"
  var words:Map[String,Boolean] = Map()
  
  def Dictionary(str:String){
    if(str != "") filename = str
    try {
      for (line <- Source.fromFile(filename).getLines()) {
        words += ( line.trim() -> true )
        //println(line)
      }
    } catch {
      case ex: FileNotFoundException => println("Couldn't find that file.")
      case ex: IOException => println("Had an IOException trying to read that file")
    }
    //println(words.size)
  }
  
  def checkEnglish(s:String):Boolean = {
    return checkForWordsRec(s,1,0)
  }
  
  def checkForWordsRec(s:String, cur:Integer, start:Integer): Boolean = {
    var ret = false
    if(cur == s.length){
      // reached the last char (base case)
      var str = s.substring(start, cur)
      print(str + ":")
      println(checkWord(str))
      if(checkWord(str)) return true
      else               return false
    }
    else if(cur == start){
      return checkForWordsRec(s,cur+1,start)
    }else{
      var str = s.substring(start, cur)
      if(checkWord(str)){
        return checkForWordsRec(s,cur+2,cur+1) || checkForWordsRec(s,cur+1,start)
      }else{
        return checkForWordsRec(s,cur+1,start)
      }
    }
    return ret
  }
  
  def checkWordsTurning(s:String):Boolean = {
    var ret = false
    
    return ret
  }
  
  def checkWord(s:String):Boolean = {
    return words.get(s).getOrElse(false)
  }
  
  def getDictionaryFromFile(str:String, clear:Boolean){
    if(clear) words = Map()
    if(str != "") filename = str
    try {
      for (line <- Source.fromFile(filename).getLines()) {
        words += ( line -> true )
        //println(line)
      }
    } catch {
      case ex: FileNotFoundException => println("Couldn't find that file.")
      case ex: IOException => println("Had an IOException trying to read that file")
    }
  }
  
  def checkWordsDictionary(s:String, m:List[String]):Boolean = {
    var ret = false
    
    
    
    
    return ret
  }
  
  
  
}