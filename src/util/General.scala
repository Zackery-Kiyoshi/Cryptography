package util

//import cryptography._
import cryptographySubstitution.CaesarCipher
import cryptographyTransposition.ColumnarTransposition
//import cryptanalysis._
import cryptanalysisSubstitution.CaesarCipherSolver
import cryptanalysisTransposition.ColumnarTranspositionSolver
import scala.io.StdIn.{readInt,readBoolean}

object General {
  def main(args: Array[String]): Unit = {
    var str = false
    var cc = new CaesarCipher()
    var ccs = new CaesarCipherSolver()
    var i:Integer = -1
    var k:String = ""
    println("e : Encrypt")
    println("d : Decrypt")
    println("s : Solve with human assistance")
    var s = readLine("")
    //val n = readInt()
    while(s != ""){
      println()
      if(s == "e"){
        test()
      }else if(s == "e"){
        k = readLine("Key: ")
        try{
          i = k.toInt
         } catch {
           case e: Exception => {
             str = true
             s = readLine("Message: ")
             s = cc.encrypt(k,s)
           }
         }
         if(!str){
           s = readLine("Message:")
           s = cc.encrypt(i,s) 
         }
        println("E(m) = " + s)
      }else if(s == "d"){
        k = readLine("Key: ")
        s = readLine("Message: ")
          var sp = cc.decrypt(1,s)
          println("D(m) = " + sp)
      }else if(s == "s"){
          s = readLine("Message: ")
          ccs.solveBruteForceInt(s)
      }
      println()
      // reset
      str = false
      println("e : Encrypt")
      println("d : Decrypt")
      println("s : Solve with human assistance")
      s = readLine("")
    }
    
  }
  
  
  def test(){
    var cc = new CaesarCipher()
    var ccs = new CaesarCipherSolver()
    var s = cc.encrypt(1,"abcdefghijklmnopqrstuvwxyz")
    var sp = cc.decrypt(1,s)
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