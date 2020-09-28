% TDA
% Bissallah Ekele (19061498) 19/04/2020
% Simple time demand analysis function 
function [w1, w2, w3] = TDA(p1,e1, p2, e2, p3, e3)
    % Wi(t) = ei + Ceiling (t/Pk)ek 
    t = 1:12;
    c1 = ceil(t/p1);
    c2 = ceil(t/p2);
    
    w3(t) = e3 + (c1 * e1 + c2 * e2);
    w3(7:12) = w3(7:12) + 1;
    %w3
    
    w2(t) = e2 + (c1 * e1);
    w2(5:8) = w2(5:8) + 2;
    w2(9:12) = w2(9:12) + 4;
    %w2
    
    w1(t) = e1;
    w1(4:6) = w1(4:6) + 1;
    w1(7:9) = w1(7:9) + 2;
    w1(10:12) = w1(10:12) + 3;
    %w1
    
end