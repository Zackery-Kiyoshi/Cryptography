package cryptographySubstitution

class CaesarCipher {
  
  var charToInt = scala.collection.mutable.Map('a'->0,'b'->1,'c'->2,'d'->3,'e'->4,'f'->5,'g'->6,'h'->7,'i'->8,'j'->9,'k'->10,'l'->11,'m'->12,'n'->13,'o'->14,'p'->15,'q'->16,'r'->17,'s'->18,'t'->19,'u'->20,'v'->21,'w'->22,'x'->23,'y'->24,'z'->25)
  var intToChar = List('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z')
  
  def encrypt(key:Integer,m:String):String = {
    var ret = ""
    var map = scala.collection.mutable.Map(' ' -> ' ')
    map -= (' ', ' ')
    //println( "Start: " + intToChar.size)
    for( i <- 0 until intToChar.size){
      var t = ((i+key)%26)
      //println( i + ":" + t)
      var c1:Char = intToChar(i)
      var c2:Char = intToChar(t)
      // println( c1 + ":" + c2)
      map += (c1->c2)
    }
    /*
    for( i <- 0 until intToChar.size){
      println(intToChar(i) + " => " + map(intToChar(i)))
    }
//  */
    //println( "End")
    for((x) <- 0 until m.length()) {
      //println("" + m.charAt(x)+ "=" + m.charAt(x).toInt + " => " + m.charAt(x).toInt+key + "=" + (m.charAt(x).toInt+key%('a'.toInt)).asInstanceOf[Char] )
       if(m.charAt(x) == m.charAt(x).toUpper){
         var t:Char = map(m.charAt(x).toLower)
         ret += t.toUpper
       }else{
         ret += map.get(m.charAt(x).toLower).get
       }
       
      //map += (m.charAt(x), (b.charAt(x).toInt - base)
    }
    //println( "Done")
    return ret
  }
  
  def encrypt(key:String,m:String):String = {
    var ret = ""
    var map = scala.collection.mutable.Map(' ' -> ' ')
    map -= (' ', ' ')
    //println( "Start: " + intToChar.size)
    var k = key.distinct
    for( i <- 0 until k.length()){
      //println( i + ":" + t)
      var c1:Char = intToChar(i)
      var c2:Char = k(i)
      //println( c1 + ":" + c2)
      map += (c1->c2)
    }
    var t = 0
    for( i <- k.length() until intToChar.size){
      while(k.contains(intToChar(t))){
        t+=1
      }
      k += intToChar(t)
      //println( i + ":" + t)
      var c1:Char = intToChar(i)
      var c2:Char = intToChar(t)
      //println( c1 + ":" + c2)
      map += (c1->c2)
    }
    /*
    for( i <- 0 until intToChar.size){
      println(intToChar(i) + " => " + map(intToChar(i)))
    }
//  */
    //println( "End")
    for((x) <- 0 until m.length()) {
      //println("" + m.charAt(x)+ "=" + m.charAt(x).toInt + " => " + m.charAt(x).toInt+key + "=" + (m.charAt(x).toInt+key%('a'.toInt)).asInstanceOf[Char] )
       if(m.charAt(x) == m.charAt(x).toUpper){
         var t:Char = map(m.charAt(x).toLower)
         ret += t.toUpper
       }else{
         //println(m.charAt(x));
         ret += map.get(m.charAt(x).toLower).get
       }
       
      //map += (m.charAt(x), (b.charAt(x).toInt - base)
    }
    //println( "Done")
    return ret
  }
  
}