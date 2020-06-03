int sumNums(int n){
    int m = n + 1;
    int sum = 0;

    int mask = 1;
    int bit = 0;
    (mask & n) && (sum += m << bit);
    mask <<= 1;
    bit++;
    (mask & n) && (sum += m << bit);
    mask <<= 1;
    bit++;
    (mask & n) && (sum += m << bit);
    mask <<= 1;
    bit++;
    (mask & n) && (sum += m << bit);
    mask <<= 1;
    bit++;
    (mask & n) && (sum += m << bit);
    mask <<= 1;
    bit++;
    (mask & n) && (sum += m << bit);
    mask <<= 1;
    bit++;
    (mask & n) && (sum += m << bit);
    mask <<= 1;
    bit++;
    (mask & n) && (sum += m << bit);
    mask <<= 1;
    bit++;
    (mask & n) && (sum += m << bit);
    mask <<= 1;
    bit++;
    (mask & n) && (sum += m << bit);
    mask <<= 1;
    bit++;
    (mask & n) && (sum += m << bit);
    mask <<= 1;
    bit++;
    (mask & n) && (sum += m << bit);
    mask <<= 1;
    bit++;
    (mask & n) && (sum += m << bit);
    mask <<= 1;
    bit++;
    (mask & n) && (sum += m << bit);

    return sum>>1;
}