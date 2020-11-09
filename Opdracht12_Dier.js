class Dier{
    constructor(naam, aantalPoten){
        this.naam = naam;
        this.aantalPoten = aantalPoten;
    }

    getNaam()
    {
        return this.naam
    }
    getAantalPoten()
    {
        return this.aantalPoten
    }
    spreek()
    {}
}

let test = new Dier('test',4)
console.log(test.getAantalPoten())
