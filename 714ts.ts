function maxProfit(prices: number[], fee: number): number {
    let cash = 0;
    let hold = -prices[0];
    for (const price of prices) {
        hold = Math.max(hold, cash - price);
        cash = Math.max(cash, hold + price - fee);
    }
    return cash;
};