package practice9;

  abstract class AbstractAsset {
    private final String ticker;
    protected double investedAmount;
    public AbstractAsset(String ticker, double investedAmount) {
        if (ticker == null || ticker.isBlank()) {
            throw new IllegalArgumentException("Тікер не може бути порожнім");
        }
        if (investedAmount <= 0) {
            throw new IllegalArgumentException("Вкладена сума має бути додатною");
        }
        this.ticker = ticker;
        this.investedAmount = investedAmount;
    }
    public String getTicker() {
        return ticker;
    }
    public double getInvestedAmount() {
        return investedAmount;
    }
    public abstract double calculateAnnualReturn();
    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + ticker;
    }
}
class GovernmentBond extends AbstractAsset {
    private final double couponRate; // фіксований купон, наприклад 0.155
    public GovernmentBond(String ticker, double investedAmount, double couponRate) {
        super(ticker, investedAmount);
        if (couponRate < 0) {
            throw new IllegalArgumentException("Купонна ставка не може бути від'ємною");
        }
        this.couponRate = couponRate;
    }
    @Override
    public double calculateAnnualReturn() {
        return investedAmount * couponRate;
    }
}
class DividendStock extends AbstractAsset {
    private final double expectedPriceGrowth; // очікуваний ріст ціни за рік, частка
    private final double dividendYield;       // дивідендна дохідність, частка
    private final double dividendTaxRate;     // податок на дивіденди, наприклад 0.195
    public DividendStock(String ticker, double investedAmount,
                         double expectedPriceGrowth, double dividendYield, double dividendTaxRate) {
        super(ticker, investedAmount);
        if (dividendYield < 0) {
            throw new IllegalArgumentException("Дивідендна дохідність не може бути від'ємною");
        }
        if (dividendTaxRate < 0 || dividendTaxRate >= 1.0) {
            throw new IllegalArgumentException("Ставка податку має бути в межах [0.0; 1.0)");
        }
        this.expectedPriceGrowth = expectedPriceGrowth; // може бути від'ємним (падіння ціни)
        this.dividendYield = dividendYield;
        this.dividendTaxRate = dividendTaxRate;
    }
    @Override
    public double calculateAnnualReturn() {
        double growth = investedAmount * expectedPriceGrowth;
        double dividendsAfterTax = investedAmount * dividendYield * (1.0 - dividendTaxRate);
        return growth + dividendsAfterTax;
    }
}
class InvestmentPortfolio {
    private final String investorName;
    private final AbstractAsset[] assets;
    public InvestmentPortfolio(String investorName, AbstractAsset[] assets) {
        if (investorName == null || investorName.isBlank()) {
            throw new IllegalArgumentException("Ім'я інвестора не може бути порожнім");
        }
        if (assets == null || assets.length == 0) {
            throw new IllegalArgumentException("Портфель має містити хоча б один актив");
        }
        for (AbstractAsset a : assets) {
            if (a == null) {
                throw new IllegalArgumentException("Актив не може бути null");
            }
        }
        this.investorName = investorName;
        this.assets = assets.clone(); // захисна копія
    }
    public String getInvestorName() {
        return investorName;
    }
    public double getTotalInvested() {
        double total = 0.0;
        for (AbstractAsset a : assets) {
            total += a.getInvestedAmount();
        }
        return total;
    }
    public double getTotalAnnualReturn() {
        double total = 0.0;
        for (AbstractAsset a : assets) {
            total += a.calculateAnnualReturn();
        }
        return total;
    }
    public double getPortfolioYieldPercent() {
        return getTotalAnnualReturn() / getTotalInvested() * 100.0;
    }
    public void printReport() {
        System.out.println("Портфель інвестора: " + investorName);
        for (AbstractAsset a : assets) {
            System.out.printf("  - %-22s вкладено: %10.2f грн, дохід за рік: %9.2f грн%n",
                    a, a.getInvestedAmount(), a.calculateAnnualReturn());
        }
        System.out.printf("  Усього вкладено: %.2f грн, річний дохід: %.2f грн (%.2f%%)%n",
                getTotalInvested(), getTotalAnnualReturn(), getPortfolioYieldPercent());
    }
}
public class PortfolioDemo {
    public static void main(String[] args) {
        double dividendTax = 0.195;
        AbstractAsset[] assets = {
            new GovernmentBond("UA-OVDP-2027", 100000, 0.155),
            new DividendStock("KO", 50000, 0.08, 0.05, dividendTax),
            new DividendStock("T", 30000, 0.04, 0.07, dividendTax)
        };
        new InvestmentPortfolio("Олександр Мельник", assets).printReport();
    }
}

