/*

    Crie a classe 'ConservacaoMarinha' para gerenciar informações
essenciais sobre conservação marinha, com propriedades como tipo de
ambiente marinho, área protegida em km2 e a presença de programas
de monitoramento. Além disso, desenvolva subclasses como
'ReservaMarinha' ou 'AreaProtegidaMarinha' e enumere os tipos de
ambientes disponíveis.

OBJETIVOS
Enumeradores, Comando lateinit, Comando With,
DataClass, Herança e Modificadores de Acesso

ENTRADA:
TipoAmbiente: String
AreaProtegidaEmKm2: Double
PossuiProgramaMonitoramento: Booleano
TipoReserva (para ReservaMarinha): String
TipoProtecao (para AreaProtegidaMarinha): String

SÁIDA:
Informações detalhadas de cada instância
criada, incluindo o tipo de ambiente marinho,
área protegida, se possui programa de
monitoramento, e detalhes específicos como
tipo de reserva ou tipo de proteção.

*/

enum class TiposAmbientes {
    OCEANO, COSTA, RECIFE, ESTUARIO
}

private abstract class ConservacaoMarinha() {
    abstract val tipoAmbiente: TiposAmbientes
    abstract val areaProtegidaEmKm2: Double
    abstract val possuiProgramaMonitoramento: Boolean
}

private data class ReservaMarinha(
    override val tipoAmbiente: TiposAmbientes,
    override val areaProtegidaEmKm2: Double,
    override val possuiProgramaMonitoramento: Boolean
) : ConservacaoMarinha() {
    lateinit var tipoReserva: String

    fun definirTipoReserva(tipo: String) {
        tipoReserva = tipo
    }
}

fun main() {
    val reservas = mutableListOf<ReservaMarinha>()

    while (true) {
        println("Escolha o tipo de ambiente (OCEANO, COSTA, RECIFE, ESTUARIO) ou digite SAIR para encerrar:")
        val tipo = readlnOrNull()?.uppercase()

        if (tipo == "SAIR") {
            break
        }

        val tipoAmbiente = try {
            TiposAmbientes.valueOf(tipo ?: "OCEANO")
        } catch (e: IllegalArgumentException) {
            println("Tipo de ambiente inválido. OCEANO será usado como valor padrão")
            TiposAmbientes.OCEANO
        }

        println("Digite a área protegida em km²:")
        val areaProtegidaEmKm2 = readlnOrNull()?.toDoubleOrNull() ?: 0.0

        println("A reserva possui programa de monitoramento(true or false)?")
        val possuiSistemaMonitoramento = readlnOrNull().toBoolean()

        val reserva = ReservaMarinha(tipoAmbiente, areaProtegidaEmKm2, possuiSistemaMonitoramento)

        println("Digite o tipo de reserva:")
        val tipoReserva = readlnOrNull() ?: "Desconhecido"
        reserva.definirTipoReserva(tipoReserva)

        reservas.add(reserva)

        println("\nReserva criada com sucesso!")
        with(reserva) {
            println("Tipo de Ambiente: $tipoAmbiente")
            println("Área Protegida: $areaProtegidaEmKm2 km²")
            println("Possui Programa de Monitoramento: $possuiProgramaMonitoramento")
            println("Tipo de Reserva: $tipoReserva")
            println()
        }
    }

    println("\nResumo das Reservas Criadas:")
    reservas.forEachIndexed { index, reserva ->
        with(reserva) {
            println("Reserva ${index + 1}:")
            println("Tipo de Ambiente: $tipoAmbiente")
            println("Área Protegida: $areaProtegidaEmKm2 km²")
            println("Possui Programa de Monitoramento: $possuiProgramaMonitoramento")
            println("Tipo de Reserva: $tipoReserva")
            println()
        }
    }
}
