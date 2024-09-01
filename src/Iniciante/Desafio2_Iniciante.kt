package Iniciante
/*
    Implemente a classe 'ConservacaoMarinha' para gerenciar
informações fundamentais sobre conservação marinha, incluindo
propriedades como tipo de ambiente marinho, área protegida
em km2 e a presença de programas de monitoramento.

OBJETIVOS
Construtores primário e secundário, recurso INIT,
Funções GET, SET e FIELD.

ENTRADA
TipoAmbiente: String
AreaProtegidaEmKm2: Double
PossuiProgramaMonitoramento: Booleano

SAÍDA
Tipo de Ambiente: Coral
Área Protegida: 100.0 km2
Possui Monitoramento: Sim

 */
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