package models

import enums.Genre

case class Movie(id: String, name: String, directors: List[Person], actors: List[Person], genre: Genre.Value , rating: String)


