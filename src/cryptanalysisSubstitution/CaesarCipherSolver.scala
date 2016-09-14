package cryptanalysisSubstitution

import cryptography._

class CaesarCipherSolver extends Cryptography {
  
  var charToInt = scala.collection.mutable.Map('a'->0,'b'->1,'c'->2,'d'->3,'e'->4,'f'->5,'g'->6,'h'->7,'i'->8,'j'->9,'k'->10,'l'->11,'m'->12,'n'->13,'o'->14,'p'->15,'q'->16,'r'->17,'s'->18,'t'->19,'u'->20,'v'->21,'w'->22,'x'->23,'y'->24,'z'->25)
  var intToChar = List('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z')
  
  def solveGeneral(m:String):String={
    var ret = "";
    
    return ret;
  }
  
  def solveBruteForce(m:String):String={
    var ret = "";
    
    for( x <- 0 until intToChar.length){
      
    }
    
    
    return ret;
  }
  
}