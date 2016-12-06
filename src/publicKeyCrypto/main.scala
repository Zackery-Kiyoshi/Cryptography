package publicKeyCrypto

import scala.io.StdIn.{ readInt, readBoolean }
import scala.io.Source
import java.io.{ FileReader, FileNotFoundException, IOException }

object main extends App {
  //println(Int.MaxValue)
  var pk = new PublicKey()
  
  //println(Int.MaxValue)
  //println(pk.stringToASCII("Hi") )
  
  var s = " "
  var i:Int = 0
  //val n = readInt()
  var k: String = ""
  while (s != "") {
    println("e  : Encrypt custom")
    println("d  : Decrypt custom")
    println("t1  : test from class")
    //println("test2  :  class")
    s = readLine("")
    println()
    if (s == "e") {
      //test()
      pk.encryptCustom()
    } else if (s == "d") {
      pk.decryptCustom()
    } else if(s == "t1"){
      val n = 101 * 109
      val e = 49
      val m = "Hi"
      val mBar = pk.encrypt(m,e,n)
      
      val d = 4849
      val ret = pk.decrypt(mBar,d,n)
      println(m + "=>" + mBar)
      println(mBar + "=>" + ret)
    } else if (s== "test2"){
      
    }
    println()
  }
}