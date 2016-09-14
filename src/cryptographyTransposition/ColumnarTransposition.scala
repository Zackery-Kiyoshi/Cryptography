package cryptographyTransposition

class ColumnarTransposition {
  
  
  def encrypt(key:Integer,msg:String, spaces:Boolean, evenLength:Boolean, de:Char, changeOrder:Boolean, order:List[Integer]):String = {
    var ret = ""
    var m = "";
    // key = numcolumns
    var columns:Array[String] = Array.fill[String](key)("")
    // whether spaces should be included in encryption
    if(!spaces){
      for( i <- msg){
        if(i != ' ' && i != '\n' && i != '\t')
          m += i
      }
    }else m = msg
    
    var c = 0;
    for( x <- 0 until m.length()){
      if(c == key) c = 0
      columns(c) += m.charAt(x) 
      c+=1
    }
    // force for a full rectangle
    if(evenLength){
      while(c != 0){
        // add the missing
        if(c == key) c =0
        else{
          columns(c) += de;
          c+=1
        }
      }
    }
    
    // how to print the columns
    /*
    for( i <- 0 until columns(0).length){
      for(j <- 0 until key){
        if(columns(j).length >= i)
          print(columns(j).charAt(i))
         else if(evenLength){
          print(columns(j).charAt(i))  
         }
      }
      println()
    }
//    */
    if(changeOrder){
      for(i <- 0 until key){
        ret +=columns(order(i))
      }
    }else{
      for(i <- 0 until key){
        ret +=columns(i)
      }
    }
    return ret
  }
  
}