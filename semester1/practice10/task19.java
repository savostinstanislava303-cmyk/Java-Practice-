package practice10;

public class task19 {
    abstract static class AbstractFinancialInstrument {
        private final String ticker;
        protected int quantity;
        public AbstractFinancialInstrument(String ticker, int quantity) {
            this.ticker = ticker;
            this.quantity = quantity;
        }
        public String getTicker() {
            return ticker;
        }

        public abstract double getMarketValueUah();
    }
    interface Tradable {
        boolean buy(int qty);
        boolean sell(int qty);
    }
    interface DividendPaying {
        double calculateAnnualDividend();
    }
    static class TechGrowthStock extends AbstractFinancialInstrument
            implements Tradable {
        private double pricePerShare;
        public TechGrowthStock(String ticker, int quantity, double pricePerShare) {
            super(ticker, quantity);
            this.pricePerShare = pricePerShare;
        }
        @Override
        public double getMarketValueUah() {
            return quantity * pricePerShare;
        }
        @Override
        public boolean buy(int qty) {
            if (qty <= 0) {
                return false;
            }

            quantity += qty;
            return true;
        }
        @Override
        public boolean sell(int qty) {
            if (qty <= 0 || qty > quantity) {
                return false;
            }
            quantity -= qty;
            return true;
        }
    }
    static class BlueChipStock extends AbstractFinancialInstrument
            implements Tradable, DividendPaying {
        private double pricePerShare;
        private double dividendPerShare;
        public BlueChipStock(String ticker, int quantity,
                             double pricePerShare, double dividendPerShare) {
            super(ticker, quantity);
            this.pricePerShare = pricePerShare;
            this.dividendPerShare = dividendPerShare;
        }
        @Override
        public double getMarketValueUah() {
            return quantity * pricePerShare;
        }
        @Override
        public boolean buy(int qty) {
            if (qty <= 0) {
                return false;
            }
            quantity += qty;
            return true;
        }
        @Override
        public boolean sell(int qty) {
            if (qty <= 0 || qty > quantity) {
                return false;
            }
            quantity -= qty;
            return true;
        }
        @Override
        public double calculateAnnualDividend() {
            return quantity * dividendPerShare;
        }
    }
    static class FixedTermDeposit extends AbstractFinancialInstrument
            implements DividendPaying {
        private double depositAmount;
        private double annualInterestRate;
        public FixedTermDeposit(String ticker, int quantity,
                                double depositAmount, double annualInterestRate) {
            super(ticker, quantity);
            this.depositAmount = depositAmount;
            this.annualInterestRate = annualInterestRate;
        }
        @Override
        public double getMarketValueUah() {
            return depositAmount;
        }
        @Override
        public double calculateAnnualDividend() {
            return depositAmount * annualInterestRate / 100.0;
        }
    }
    public static void main(String[] args) {
        TechGrowthStock techStock =
                new TechGrowthStock("TECH", 10, 500.0);
        BlueChipStock blueChip =
                new BlueChipStock("BLUE", 20, 300.0, 15.0);
        FixedTermDeposit deposit =
                new FixedTermDeposit("DEPOSIT", 1, 50000.0, 10.0);
        AbstractFinancialInstrument[] instruments = {
                techStock,
                blueChip,
                deposit
        };
        System.out.println("=== ТОРГІВЛЯ ===");
        System.out.println("Купівля TECH: " + techStock.buy(5));
        System.out.println("Продаж BLUE: " + blueChip.sell(5));
        System.out.println("\n=== РИНКОВА ВАРТІСТЬ ===");
        for (AbstractFinancialInstrument instrument : instruments) {
            System.out.println(instrument.getTicker() + ": " +
                    instrument.getMarketValueUah() + " грн");
        }
        System.out.println("\n=== РІЧНІ ДИВІДЕНДИ / ВІДСОТКИ ===");
        for (AbstractFinancialInstrument instrument : instruments) {
            if (instrument instanceof DividendPaying) {
                DividendPaying dividend = (DividendPaying) instrument;
                System.out.println(instrument.getTicker() + ": " +
                        dividend.calculateAnnualDividend() + " грн");
            } else {
                System.out.println(instrument.getTicker() +
                        ": не виплачує дивіденди");
            }
        }
    }
}

