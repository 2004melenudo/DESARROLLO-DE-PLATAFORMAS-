const val TASA_ITF = 0.00005

fun calcularComision(mr: Double): Double {
    return when {
        mr <= 1000.0 -> 5.0
        mr <= 10001.0 -> mr * 0.005
        else -> mr * 0.015
    }
}

fun calcularITF(mr: Double): Double {
    return mr * TASA_ITF
}

fun calcularRemesa(total: Double): Double? {
    return when {
        total < 5.0 -> null
        total <= 1005.05 -> (total - 5.0) / 1.00005
        total <= 10051.50505 -> total / 1.00505
        total <= 10151.51505 -> null
        else -> total / 1.01505
    }
}

fun main(args: Array<String>) {
    println("================================")
    println("     PROBLEMA DE REMESAS")
    println("================================")

    if (args.isEmpty()) {
        println("Ingrese el monto total en Program arguments.")
        println("Por ejemplo: 2000")
        return
    }

    val total = args[0].toDoubleOrNull()

    if (total == null) {
        println("Error: debe ingresar un número válido.")
        return
    }

    val remesa = calcularRemesa(total)

    if (remesa == null) {
        println("El monto total no corresponde a una remesa válida.")
    } else {
        val itf = calcularITF(remesa)
        val comision = calcularComision(remesa)
        val comprobacion = remesa + itf + comision

        println("Monto total: S/ %.2f".format(total))
        println("Remesa: S/ %.2f".format(remesa))
        println("ITF: S/ %.4f".format(itf))
        println("Comisión: S/ %.2f".format(comision))
        println("Comprobación: S/ %.2f".format(comprobacion))
    }
}fun main() {
    val kotlin = " "
    println(kotlin)
}
