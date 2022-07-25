
             
SELECT CONCAT(f.title, "duração de ", SEC_TO_TIME(f.length)) as 'Filme e Duração' /* A Função SEC_TO_TIME() retorna o valor TIME (no formato HH:MM:SS) os valores adicionados serão segundos. Fonte: https://www.w3schools.com/sql/func_mysql_sec_to_time.asp  */
FROM film as f;

/*	Saída:

f.length = 80;

-----------------------------------------------------+
| Filme e Duração                                    |
+----------------------------------------------------+
|[f.title] duração de 00:01:20                       |
|                                                    |
+----------------------------------------------------+


*/

SELECT CONCAT(f.title, "duração de ", SEC_TO_TIME(f.length * 60)) as 'Filme e Duração' /* Como os valores que são adiocionados ao SEC_TO_TIME são segundos e nosso f.length representa minutos */
FROM film as f;																		   /* Foi adicionado o vezes sessenta(* 60), assim, convertendo os minutos em segundos.                    */

/*	Saída:

f.length = 80;

-----------------------------------------------------+
| Filme e Duração                                    |
+----------------------------------------------------+
|[f.title] duração de 01:20:00                       |
|                                                    |
+----------------------------------------------------+


*/