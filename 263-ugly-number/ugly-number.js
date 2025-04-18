/**
 * @param {number} n
 * @return {boolean}
 */
var isUgly = function(n) {
    if(n<=0){return false;}
    let c=1,m=n;
    while(c!=0){
        c=0;
        if(m%2==0){m/=2;c++;}
        if(m%3==0){m/=3;c++;}
        if(m%5==0){m/=5;c++;}}
        return m==1;

};