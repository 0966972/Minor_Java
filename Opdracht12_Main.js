let dier = new Dier("Dier",2)  
let hond = new Hond("Hond", 5);
let kat = new Kat("Kat");

console.log(dier.getAantalPoten, dier.getNaam)
console.log(hond.getAantalPoten, hond.getNaam)
console.log(kat.getAantalPoten, kat.getNaam)

console.log(dier.getAantalPoten(), dier.getNaam())
console.log(hond.getAantalPoten(), hond.getNaam())
console.log(kat.getAantalPoten(), kat.getNaam())