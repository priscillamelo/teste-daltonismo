package tads.eaj.ufrn.testededaltonismo

data class Teste(var res1: String, var res2: String, var res3: String, var result: Int) {

    fun respostaFinal(): Int {
        if (res1 == " " || res2 == " " || res3 == " "){
            result = -1
        } else if (res1 == "2" && res2 == "10" && res3 == "74"){
            result = 1
        } else {
            result = 0
        }
        return result
    }
}
