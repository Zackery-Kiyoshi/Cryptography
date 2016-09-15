package cryptographySubstitution

class CaesarCipher {
  
  var charToInt = scala.collection.mutable.Map(' '->(-1), 'a'->0,'b'->1,'c'->2,'d'->3,'e'->4,'f'->5,'g'->6,'h'->7,'i'->8,'j'->9,'k'->10,'l'->11,'m'->12,'n'->13,'o'->14,'p'->15,'q'->16,'r'->17,'s'->18,'t'->19,'u'->20,'v'->21,'w'->22,'x'->23,'y'->24,'z'->25)
  var intToChar = List('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z')
  
  def encrypt(key:Integer,m:String):String = {
    return encrypt(key,m,5,"x")
  }
  
  def encrypt(key:Integer,m:String, block:Integer, fill:String):String = {
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
    var i = block
    while(i < ret.length ){
      val (p1, p2) = ret.splitAt(i)
      ret = p1 + " " + p2
      i += block+1
    }
    if(i > ret.length && fill != ""){
        for(j <- ret.length until i) ret += fill
      }
    return ret
  }
  
  def decrypt(key:Integer,m:String):String = {
    return decrypt(key,m,5)
  }
  
  def decrypt(key:Integer,m:String, blocks:Integer):String = {
    var ret = ""
    var map = scala.collection.mutable.Map('`' -> ' ')
    map -= ('`', ' ')
    var msg = m
    if(blocks == 0){
      msg = m.replaceAll(" ","")
    }
    //println( "Start: " + intToChar.size)
    for( i <- 0 until intToChar.size){
      var t = ((i+key)%26)
      //println( i + ":" + t)
      // THis is the only difference
      var c1:Char = intToChar(t)
      var c2:Char = intToChar(i)
      // println( c1 + ":" + c2)
      map += (c1->c2)
    }
    /*
    for( i <- 0 until intToChar.size){
      println(intToChar(i) + " => " + map(intToChar(i)))
    }
//  */
    //println( "End")
    for((x) <- 0 until msg.length()) {
      //println("" + m.charAt(x)+ "=" + m.charAt(x).toInt + " => " + m.charAt(x).toInt+key + "=" + (m.charAt(x).toInt+key%('a'.toInt)).asInstanceOf[Char] )
       if(msg.charAt(x) == msg.charAt(x).toUpper){
         var t:Char = map(msg.charAt(x).toLower)
         ret += t.toUpper
       }else{
         ret += map.get(msg.charAt(x).toLower).get
       }
       
      //map += (m.charAt(x), (b.charAt(x).toInt - base)
    }
    //println( "Done")
    if(blocks !=0){
      var i = blocks
      while(i < ret.length ){
        val (p1, p2) = ret.splitAt(i)
        ret = p1 + " " + p2
        i += blocks+1
      }
    }
    
    return ret
  }
  
  def encrypt(key:String,m:String):String = {
    return encrypt(key,m,5,"x")
  }
  
  def encrypt(key:String,m:String, block:Integer, fill:String):String = {
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
    var i = block
    while(i < ret.length ){
      val (p1, p2) = ret.splitAt(i)
      ret = p1 + " " + p2
      i += block+1
    }
    if(i > ret.length && fill != ""){
        for(j <- ret.length until i) ret += fill
      }
    
    return ret
  }
  
  def decrypt(key:String,m:String):String = {
    return decrypt(key,m,5)
  }
  def decrypt(key:String,m:String, blocks:Integer):String = {
    var ret = ""
    var map = scala.collection.mutable.Map(' ' -> ' ')
    map -= (' ', ' ')
    var msg = m
    if(blocks == 0){
      msg = m.replaceAll(" ","")
    }
    
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
    for((x) <- 0 until msg.length()) {
      //println("" + m.charAt(x)+ "=" + m.charAt(x).toInt + " => " + m.charAt(x).toInt+key + "=" + (m.charAt(x).toInt+key%('a'.toInt)).asInstanceOf[Char] )
       if(m.charAt(x) == msg.charAt(x).toUpper){
         var t:Char = map(msg.charAt(x).toLower)
         ret += t.toUpper
       }else{
         //println(m.charAt(x));
         ret += map.get(msg.charAt(x).toLower).get
       }
       
      //map += (m.charAt(x), (b.charAt(x).toInt - base)
    }
    //println( "Done")
    if(blocks !=0){
      var i = blocks
      while(i < ret.length ){
        val (p1, p2) = ret.splitAt(i)
        ret = p1 + " " + p2
        i += blocks+1
      }
    }
    
    return ret
  }
  
}