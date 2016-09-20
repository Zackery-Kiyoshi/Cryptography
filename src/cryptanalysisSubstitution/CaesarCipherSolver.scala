package cryptanalysisSubstitution

import cryptography._
import util.Dictionary

class CaesarCipherSolver extends Cryptography {
  
  val charToInt = scala.collection.mutable.Map('a'->0,'b'->1,'c'->2,'d'->3,'e'->4,'f'->5,'g'->6,'h'->7,'i'->8,'j'->9,'k'->10,'l'->11,'m'->12,'n'->13,'o'->14,'p'->15,'q'->16,'r'->17,'s'->18,'t'->19,'u'->20,'v'->21,'w'->22,'x'->23,'y'->24,'z'->25)
  val intToChar = List('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z')
  var dic = new Dictionary()
  
  def solveGeneral(m:String):String={
    var ret = "";
    
    return ret;
  }
  
  def solveBruteForceInt(m:String):String={
    var ret = ""
    for( i <- 0 to 25){
      for(j <- 0 until m.length){
        if(m.charAt(j) != ' '){
          var tmp = (charToInt(m.charAt(j))+i) % 26
          //println(tmp)
          ret += intToChar(tmp)
        }
      }
      
      println(i + ":'" + ret + "'")
      ret = ""
    }
    
    return ret
  }
  
  def solveBruteForceIntWithComp(m:String):String={
    var ret = ""
    for( i <- 0 to 25){
      for(j <- 0 until m.length){
        if(m.charAt(j) != ' '){
          var tmp = (charToInt(m.charAt(j))+i) % 26
          //println(tmp)
          ret += intToChar(tmp)
        }
      }
      if(dic.checkEnglish(ret)){
        println(i + ":'" + ret + "'")
      }
      ret = ""
      
    }
    
    return ret
  }
  
}