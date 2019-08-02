package com.fox.polyproduct.model

class Product {
    lateinit var name:String
    lateinit var price:String
    lateinit var description:String

    constructor(name: String,price:String,description:String) {
        this.name = name
        this.price = price
        this.description = description
    }

    constructor()
}