#include<bits/stdc++.h>
using namespace std;
#define endl '\n' 
#define faster() ios_base::sync_with_stdio(0); cin.tie(NULL); cout.tie(NULL);
#define ll long long
bool check(ll u){
    int a[3]={0};
    string s=to_string(u);
    // cout << s << endl;
    for (int i=0; i<s.size(); i++){
        if (s[i]=='5') a[1]++;
        else if (s[i]=='3') a[0]++;
        else if (s[i]=='7') a[2]++;
        else return 0;
    }
    if (a[0]==0 || a[1]==0 || a[2]==0) return 0;
    return 1;
}
int main()
{
    faster();
    int n;  cin >> n;
    queue <ll> q;
    ll si=0;
    ll cnt=0;
    q.push(si);
    while (!q.empty()){
        ll u=q.front();
        q.pop();
        //  cout << u << " ";
        if (u > n) break;
        q.push(u*10+3);
        q.push(u*10+5);
        q.push(u*10+7);
        if (check(u)){
            cnt++;
        }
    }
    cout << cnt << endl;
}