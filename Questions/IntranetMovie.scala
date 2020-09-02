
// Begin set up. Don't judge me for this, code was given in book
case class Film (name: String, yearOfRelease: Int, imdbRating: Double)

case class Director(
    firstName: String,
    lastName: String,
    yearOfBirth: Int,
    films: Seq[Film]
)

// Movies 
val memento = new Film("Memento", 2000, 8.5)
val darkKnight=new Film("DarkKnight", 2008, 9.0)
val inception=new Film("Inception", 2010, 8.8)
val highPlainsDrifter =new Film("HighPlainsDrifter", 1973, 7.7)
val outlawJoseyWales  =new Film("TheOutlawJoseyWales", 1976, 7.9)
val unforgiven=new Film("Unforgiven", 1992, 8.3)
val granTorino=new Film("GranTorino", 2008, 8.2)
val invictus=new Film("Invictus", 2009, 7.4)
val predator=new Film("Predator", 1987, 7.9)
val dieHard=new Film("DieHard", 1988, 8.3)
val huntForRedOctober =new Film("TheHuntforRedOctober", 1990,7.6)
val thomasCrownAffair =new Film("TheThomasCrownAffair", 1999, 6.8)

// Directors
val eastwood =new Director("Clint","Eastwood", 1930,Seq(highPlainsDrifter, outlawJoseyWales, unforgiven, granTorino,invictus))
val mcTiernan =new Director("John","McTiernan", 1951,Seq(predator, dieHard, huntForRedOctober, thomasCrownAffair))
val nolan =new Director("Christopher","Nolan", 1970, Seq(memento, darkKnight, inception))
val someGuy = new Director("Just", "Some Guy", 1990, Seq())
val directors = Seq(eastwood,mcTiernan,nolan,someGuy)

// End of set up

// Find all directors that have directed N number of films
def numberOfFilms(N:Int,directors:Seq[Director]):Seq[Director] =
  directors.filter(_.films.length>=N)

// Directors born before some year, Y
def beforeYearY(Y:Int,directors:Seq[Director]):Seq[Director] =
  directors.filter(_.yearOfBirth < Y)
// Accept two parameters,year and number Of Films, and return a listof directors who were born before year who have also directed more than than number Of Films
def helper(Y:Int, N:Int,directors:Seq[Director]): Seq[Director] ={
  // Filter each section of query separately then find the intersection
  val byAge = directors.filter(_ .yearOfBirth < Y)
  val byFilm = directors.filter(_.films.length>=N)
  byFilm.filter(byAge.contains)
}

// Accept a parameter 'ascending' of type Boolean that defaults to true. Sort the directors by age in the specified order
def ageOrder(ascending:Boolean = true,directors:Seq[Director]): Seq[Director] = {
  if(ascending)
    directors.sortWith((a,b) => a.yearOfBirth < b.yearOfBirth)
  else
    directors.sortWith((a,b) => a.yearOfBirth  > b.yearOfBirth)
} 
val nolanFilms = nolan.films.map((film)=>film.name)
val allFilmNames = directors.flatMap((director=>director.films.map(film => film.name)))
val earliestMctFilm = mcTiernan.films.map(film => film.yearOfRelease).fold(Int.MaxValue)((f1,f2)=>math.min(f1,f2))
//Another option  mcTiernan.films.sortWith((a,b) => a.yearOfRelease < b.yearOfRelease).headOption
