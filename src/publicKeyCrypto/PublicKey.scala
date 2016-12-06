package publicKeyCrypto

class PublicKey {

  def stringToASCII(s: String): Int = {
    var bString = ""
    var temp = ""
    for (i <- 0 until s.length()) {
      temp = Integer.toBinaryString(s(i))
      for (j <- temp.length() until 8) {
        temp = "0" + temp
      }
      bString += temp
    }
    //println(bString)
    return Integer.parseInt(bString, 2)
  }

  def encryptCustom() {
    var n: Double = -1
    var e: Double = -1
    var m: String = ""
    // generate v

    println("Do you want to enter values for p/q/e (or they can be generated): [y/n]")
    println("generated is not actually working")
    var tmp = readLine()
    if (tmp.contains('y')) {
      println("enter value for p:")
      val p = readDouble()
      println("enter value for q:")
      val q = readDouble()
      n = preEncrypt(p, q)
      // need to get e - gcd(e,(p-1)(q-1)) == 1 
      println("Enter value for e:")
      e = readInt()

      m = readLine("Enter message to encrypt:")

    } else if (tmp.contains('n')) {
      m = readLine("Enter message to encrypt:")
      // need to calculate values for p and q

      // calculate e

    }
    val mBar = encrypt(m, e, n)
    println("m: " + stringToASCII(m))
    println("mBar: " + mBar)

  }

  def decryptCustom() {
    // calculate d: de = 1(mod((p-1)(q-1)))
    var d = 0

    println("Do you want to enter values for d (or they can be generated): [y/n]")
    println("generated is not actually working")
    var tmp = readLine()
    println("Enter message to decrypt:")
    var mBar = readInt()
    println("Enter value for n:")
    var n = readInt()
    if (tmp.contains('y')) {
      println("Enter value for d:")
      d = readInt()
    } else if (tmp.contains('n')) {
      // calculate d: de = 1(mod((p-1)(q-1)))

    }

    val m = decrypt(mBar, d, n)
    println(m)
    println(m.toString)
  }

  def powerModN(b: Double, m: Double, n: Double): Double = {
    if (m == 0) {
      return 1
    } else {
      //println(b + "," + Math.floor(m/2) + "," + n)
      var t = Math.pow(powerModN(b, Math.floor(m / 2), n), 2)
      if (m % 2 == 1) {
        t = t * b
      }
      return t % n
    }
  }

  def preEncrypt(p: Double, q: Double): Double = {
    // possibly generate
    return p * q
  }

  def encrypt(m: String, e: Double, n: Double): Double = {
    return powerModN(stringToASCII(m), e, n)
  }

  def decrypt(mBar: Double, d: Double, n: Double): Double = {
    return powerModN(mBar, d, n)
  }

}