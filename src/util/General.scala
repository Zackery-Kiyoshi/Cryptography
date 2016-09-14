package util

//import cryptography._
import cryptographySubstitution.CaesarCipher
import cryptographyTransposition.ColumnarTransposition
//import cryptanalysis._
import cryptanalysisSubstitution.CaesarCipherSolver
import cryptanalysisTransposition.ColumnarTranspositionSolver

object General {
  def main(args: Array[String]): Unit = {
    
    var cc = new CaesarCipher()
    var ccs = new CaesarCipherSolver()
    var s = cc.encrypt(1,"abcdefghijklmnopqrstuvwxya",5,"a")
    var sp = cc.decrypt(1,s,true)
    //ccs.solveBruteForceInt(s)
    println(s )
    println(sp)
    s = cc.encrypt("mockingbird","abcdefghijklmnopqrstuvwxyz")
    //println(s)
    
    var ctc = new ColumnarTransposition()
    s = ctc.encrypt(5,"come to my house at noon tomorrow", false, true, 'x', false, List(0,1,2,3,4) )
    //println(s)
    //s = ctc.encrypt(5,"come to my house at noon tomorrow", false, true, 'x', true, List(1,0,2,4,3) )
    //println(s)
    var ctcs = new ColumnarTranspositionSolver()
    s = ctcs.displayColumns(5,s)
    //println(s)
  }
}