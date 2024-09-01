package Iniciante

class ConservacaoMarinha(tipoAmbiente: String, areaProtegidaKm2: Double, possuiProgramaMonitoramento: Boolean) {

    constructor() : this("Oceano", 0.0, false)

    var tipoAmbiente: String = tipoAmbiente
        get() { return field }
        set(value) { field = value }

    var areaProtegidaKm2: Double = areaProtegidaKm2
        get() { return field }
        set(value) { field = value }

    var possuiProgramaMonitoramento: Boolean = possuiProgramaMonitoramento
        get() { return field }
        set(value) { field = value }

    init {
        println("\nTipo de Ambiente: $tipoAmbiente")
        println("Área Protegida: $areaProtegidaKm2 km²")
        if (possuiProgramaMonitoramento) {
            println("Possui Monitoramento: Sim ")
        } else{
            println("Possui Monitoramento: Não ")
        }
    }
}

fun main(){

    println("Tipo de ambiente:")
    val tipoAmbiente = readln()

    println("Area Protegida em km²:")
    val areaProtegidaKm2 = readln().toDouble()

    println("A area possui ponto de monitoramento: ")
    val possuiProgramaMonitoramento = readln().lowercase()

    val monitoramento = if(possuiProgramaMonitoramento == "sim"){true}
    else{false}

    if(tipoAmbiente == "" && areaProtegidaKm2 < 0.0 && possuiProgramaMonitoramento == ""){
        var conservacaoPadrao:ConservacaoMarinha = ConservacaoMarinha()
    }else{
        var conservacao:ConservacaoMarinha = ConservacaoMarinha(tipoAmbiente, areaProtegidaKm2, monitoramento)
    }
}