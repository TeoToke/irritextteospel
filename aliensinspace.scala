import scala.io.StdIn.readLine
import scala.util.Random

@main def startGame = {borjaspel}

def borjaspel: Unit = {println({"""Du är en Alien som flyger genom rymden. 
Onej! Ett fel har uppstått i skeppet.
Du måste ta dig ut ur din fryssäng, vad gör du?"""}.stripMargin)
del1}

def del1= {
    println({"""
    1. Ställ dig upp
    2. Ligg kvar och sov
    3. Smält ned sängen med din enorma hjärna"""}.stripMargin)

    val choice1 = readLine().toInt
    if choice1 == 3 then del2 
    else if choice1 == 1 then {println("Du är fast fryst! Du kan inte röra på dig"); skeppkrasch}
    else if choice1 == 2 then {println("Du slår på väckarklockan och somnar om"); skeppkrasch}
    else if choice1 == 55 then mattemanick
    else ingetval
    
}

def del2= {
    println({"""Sängen smälts ned, du sjunker långasmt ned på golvet. Du ligger nu i en vattenpöl. Onej! Din mekaniska kropp är inte på! Du måste sätta på den, men hur då?
    1. Ät frukost
    2. scala run mekaniskamoduler.scala
    3. Använd telekenes för att röra dig """}.stripMargin)

    val choice2 = readLine().toInt
    if choice2 == 1 then del3 
    else if choice2 == 2 then {println("""[error]  File not found: C:\Users\xXAlien1453Xx\bodycomputer\mekaniskamoduler.scala"""); skeppkrasch}
    else if choice2 == 3 then {println("Du tänker så hårt du kan tills du ställer dig frågan, vad är telekenes?"); skeppkrasch}
    else ingetval
    
}

def del3 = {
    println({"""Jasåklart! Genom din tankemodul sätter du igång brödrosten som låg brevid din fryssäng. Den går igån och shockar din kropp i vattenpölen. Du kan nu röra på dig. Du befinner dig i: SOVRUM. Vad gör du? 
    1. Kontrollrum
    2. Kök
    3. Rymden"""}.stripMargin)

    val choice3 = readLine().toString.toLowerCase
    if choice3 == "kontrollrum" then kontrollrum 
    else if choice3 == "kok" then kok
    else if choice3 == "rymden" then rymden
    else {println("Du kommer inte ihåg att det är en plats i skeppet (eller vet inte hur du tar dig dit)."); skeppkrasch}

}

def sovrum = {
    println("Grattis! Du tog dig tillbaka till sovrummet, det gör väldigt ont att stå i brödrost-el-pölen. Här finns inget att göra")
    println("Du kan gå till: Kök, Kontrollrum, Rymden")
    isovrum
    def isovrum: Unit = {
    val fransovrum = readLine().toString().toLowerCase()

    if fransovrum == "kontrollrum" then kontrollrum
    else if fransovrum == "kok" then kok
    else if fransovrum == "rymden" then rymden
    else println("Du kommer inte ihåg att det är en plats i skeppet (eller vet inte hur du tar dig dit)"); isovrum
    }
}

def kok: Unit = {
    println("Du går in i köket. Wowza! Vilka coola alien kryddor, dem kanske kan hjälpa?")
    println("Du kan gå till: Sovrum, Rymden")
    ikok
    def ikok: Unit = {
    val frankok = readLine().toString().toLowerCase()

    if frankok == "sovrum" then sovrum
    else if frankok == "rymden" then rymden
    else {println("Du kommer inte ihåg att det är en plats i skeppet (eller vet inte hur du tar dig dit)"); ikok}
    }
}

def kontrollrum: Unit = {
    println("Du går in i kontrollrummet. Här finns en massa skärmar och makapärer, alla visar error. Du fattar ingenting, här finns inget att göra")
    choice = choice +1
    xs(choice >= 3)
    println("Du kan gå till: Sovrum, Rymden")
    ikontrollrum

    def ikontrollrum: Unit = {
    val frankontrollrum = readLine().toString().toLowerCase()

    if frankontrollrum == "mattemanicken(tm)" then mattemanick 
    else if frankontrollrum == "rymden" then rymden
    else if frankontrollrum == "sovrum" then sovrum
    else println("Du kommer inte ihåg att det är en plats i skeppet (eller vet inte hur du tar dig dit)"); ikontrollrum
    }
    
}

def rymden = {println("Du sugs ut i rymden och dör"); skeppkrasch}

def mattemanick: Unit = {
    println("mattemanicken(tm) har kraschat! Du startar om den men möts av en CAPATCHA " +
    "(Completely Automated Public Alien test to tell Aliens and Humans Apart). Du måste lösa följande matte formel för att kunna starta igång manicken:")
    var ledtrad = 0
    matteproblem
    
    def matteproblem: Unit = {
    
    val a = ((math.random*10).toInt).toDouble
    val b = (((math.random*100)+math.random*10).toInt).toDouble
    def randomnamnare: Double = {
        val rn = Vector(2.0, 4.0, 5.0, 8.0, 10.0)
        rn(Random.nextInt(5)).toDouble
    }
    val c = randomnamnare
    val d = a + b
    val x = (((c*d)-b)/c)
    println(s"((x * $a) + $b)/ $c = $d")
    val mattesvar = readLine().toDouble
    svar(mattesvar)
    
    def svar(ms: Double): Unit = {
        if (ms == x+1) then {println("""Yipee mattemanicken(tm) är fixad och du kan nu flyga kontrollerat igen. Du tar dig till planeten jorden och spränger upp den. Ditt upprdag är avklarat""")}
        else if (ms == x) then {
            if (ledtrad >= 3) then {println("Du kom på alienregeln! Allt blir bättre om man lägger till 1")
            matteproblem}
            else println("Hmm, du har glömt Alien regeln. Något i ditt svar saknas")
            ledtrad = ledtrad + 1
            matteproblem}
        else {println("Hmm, nej det stämmer inte")
        matteproblem}
    
    }

    }
}

def ingetval = {println("Det går inte, du kommer inte på något!"); skeppkrasch }

def hastighet: String = {
    val g = (math.random * 299000000).toInt
    s"$g meter per sekund"
}


def skeppkrasch = {
    println(s"Skeppet flyger in i en asterod i $hastighet")
    Thread.sleep(3000)
    for (i <- 1 to 21) println()
    println("Men det var bara en dröm...")
    choice = 0
    borjaspel
}


var choice = 0

def xs(a: Boolean): Unit =
    if a then println("Efter att ha sprungit ut och in märker du att det är någor fel på mattemanicken(tm)")