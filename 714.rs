impl Solution {
    pub fn max_profit(prices: Vec<i32>, fee: i32) -> i32 {
        let mut s0 = 0;
        let mut s1 = -prices[0];
        for price in prices {
            s1 = s1.max(s0 - price);
            s0 = s0.max(price + s1 - fee);
        }
    return s0;
    }
}