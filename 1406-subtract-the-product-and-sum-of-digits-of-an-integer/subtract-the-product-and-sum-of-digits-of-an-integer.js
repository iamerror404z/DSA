/**
 * @param {number} n
 * @return {number}
 */
var subtractProductAndSum = function(n) {
    let pro=1,sum=0;
    let b=n,digit=0;
    while(b!=0){
        digit=b%10;
        pro*=digit;
        sum+=digit;
        b=Math.floor(b/10);}
    return (pro-sum);
    
};