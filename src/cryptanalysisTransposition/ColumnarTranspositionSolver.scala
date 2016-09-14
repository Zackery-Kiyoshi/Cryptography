package cryptanalysisTransposition

import cryptanalysis._

class ColumnarTranspositionSolver {
  def solveGeneral(m:String):String={
    var ret = "";
    
    return ret;
  }
  
  def displayColumns(key:Integer,msg:String):String = {
    var ret = ""
    var columns:Array[String] = Array.fill[String](key)("")
    
    for( i <- 0 until msg.length()){
      if(i != 0 && i%key == 0){
        //println()
        ret += '\n'
      }
      //print(msg.charAt(i))
      ret += msg.charAt(i)
    }
    return ret
  }
}