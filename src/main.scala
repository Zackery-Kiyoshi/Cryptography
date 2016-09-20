import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException
import scala.io.StdIn.{readInt,readBoolean}
import scala.io.Source

import cryptographySubstitution.CaesarCipher
import cryptographyTransposition.ColumnarTransposition
import cryptanalysisSubstitution.CaesarCipherSolver
import cryptanalysisTransposition.ColumnarTranspositionSolver
import util._

var str = false
var cc = new CaesarCipher()
var ccs = new CaesarCipherSolver()
var dic = new Dictionary()
dic.getDictionaryFromFile("words",false)
    
var i:Integer = -1
var k:String = ""
    
//println(dic.checkWord("e"))
//println(dic.checkForWordsRec("fucker", 5, 0) )
//println(dic.checkEnglish("fucker") )
    
println("e  : Encrypt")
println("d  : Decrypt")
println("sh : Solve with human assistance")
println("c  : Check if a blocked text is English words")
println("sc : Solve with computer assistance")
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
    }else if(s == "sh"){
        s = readLine("Message: ")
        ccs.solveBruteForceInt(s)
    }else if(s == "c"){
      s = readLine("Message to check: ")
      println(dic.checkEnglish(s) )
    }else if(s == "sc"){
      s = readLine("Message: ")
      println(dic.checkEnglish(s) )
    }
    println()
    // reset
    str = false
    println("e  : Encrypt")
    println("d  : Decrypt")
    println("sh : Solve with human assistance")
    println("c  : Check if a blocked text is English words")
    println("sc : Solve with computer assistance")
    s = readLine("")
  }