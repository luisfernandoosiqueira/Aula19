/*
 * Copyright (C) 2024 Luís Fernando Siqueira <luisfernandosqueiraadv@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package dataHora;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 *
 * @author Luís Fernando Siqueira <luisfernandosqueiraadv@gmail.com>
 * @date 15/04/2024
 * @brief Class Ex04_DiferencaFuso
 */
public class Ex04_DiferencaFuso {

    // Método principal que é o ponto de entrada do programa.
    public static void main(String[] args) {

        // Cria um Instant a partir da string fornecida
        Instant d06 = Instant.parse("2022-07-20T01:30:26Z");

        // Cria LocalDate e LocalDateTime a partir do Instant d06 aplicando o fuso horário padrão do sistema
        LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());

        // Cria LocalDate a partir do Instant d06 aplicando o fuso horário específico de Portugal
        LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));

        // Cria LocalDateTime a partir do Instant d06 aplicando o fuso horário padrão do sistema
        LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());

        // Cria LocalDateTime a partir do Instant d06 aplicando o fuso horário específico de Portugal
        LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));

        // As variáveis r1 e r3 foram criadas com base no Instant d06. Aqui elas são usadas para extrair e imprimir
        // informações de data e hora, como o dia, mês, ano, hora e minuto.
        
        // Extrai e imprime o dia do mês de r1
        System.out.println("r1 dia = " + r1.getDayOfMonth());
        
        // Extrai e imprime o mês de r1
        System.out.println("r1 mês = " + r1.getMonthValue());
        
        // Extrai e imprime o ano de r1
        System.out.println("r1 ano = " + r1.getYear());

        // Extrai e imprime a hora de r3
        System.out.println("r3 hora = " + r3.getHour());
        
        // Extrai e imprime o minuto de r3
        System.out.println("r3 minuto = " + r3.getMinute());

        // Imprime as datas e horas formatadas dos objetos LocalDate e LocalDateTime
        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r3 = " + r3);
        System.out.println("r4 = " + r4);
    }
}
