package practice5;
public class homewok54 {
    public static void main(String[] args) {
        System.out.println("=== ЗАВДАННЯ 4 ===");
                String[] heroes = {
                        "Pudge", "Invoker", "Juggernaut",
                        "Crystal Maiden", "Earthshaker"
                };
                int[] kills = {8, 12, 10, 2, 4};
                int[] deaths = {6, 3, 2, 9, 5};
                int[] assists = {14, 9, 8, 18, 16};
                int[] netWorth = {14500, 21200, 24800, 9800, 12300};
                double[] kdaRatios = new double[5];
                int totalTeamKills = 0;
                int totalNetWorth = 0;
                int mvpIndex = 0;
                for (int i = 0; i < heroes.length; i++) {
                    totalTeamKills += kills[i];
                    totalNetWorth += netWorth[i];
                    kdaRatios[i] = (double) (kills[i] + assists[i])
                            / Math.max(1, deaths[i]);
                    if (kdaRatios[i] > kdaRatios[mvpIndex]) {
                        mvpIndex = i;
                    }
                }
                System.out.println("========================================================================");
                System.out.println("                 DOTA 2: POST-MATCH REPORT");
                System.out.println("========================================================================");
                System.out.printf("%-18s | %-11s | %-10s | %-9s | %-20s%n",
                        "Герой", "K / D / A", "Net Worth", "KDA Ratio",
                        "Kill Participation");
                System.out.println("------------------------------------------------------------------------");
                for (int i = 0; i < heroes.length; i++) {
                    double participation =
                            (double) (kills[i] + assists[i]) / totalTeamKills * 100;

                    System.out.printf("%-18s | %2d / %d / %2d | %,9d | %9.2f | %18.2f%%%n",
                            heroes[i],
                            kills[i],
                            deaths[i],
                            assists[i],
                            netWorth[i],
                            kdaRatios[i],
                            participation);
                }
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Загальна кількість вбивств команди: "
                        + totalTeamKills);
                System.out.printf("Сумарний Net Worth команди: %,d золота%n",
                        totalNetWorth);
                System.out.printf("НАЙКРАЩИЙ ГРАВЕЦЬ МАТЧУ (MVP): %s (KDA: %.2f)%n",
                        heroes[mvpIndex], kdaRatios[mvpIndex]);
                System.out.println("========================================================================");
            }
        }


