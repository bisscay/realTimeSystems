% LAB E
% Bissallah Ekele (19061498) 19/04/2020
% Run this file
close all

% Prompt user (Press Enter to Assign Default Values)
p1 = input('Enter Task1 period p1 (3 default) :-'); 
if isempty(p1)
   p1 = 3;
end

e1 = input('Enter Task1 exec e1 (1 default) :-'); 
if isempty(e1)
   e1 = 1;
end

p2 = input('Enter Task2 period p1 (4 default) :-'); 
if isempty(p2)
   p2 = 4;
end

e2 = input('Enter Task2 exec e2 (2 default) :-'); 
if isempty(e2)
   e2 = 2;
end

p3 = input('Enter Task3 period p3 (6 default) :-'); 
if isempty(p3)
   p3 = 6;
end

e3 = input('Enter Task1 exec e3 (1 default) :-'); 
if isempty(e3)
   e3 = 1;
end

% Call simple time demand analysis function 
[r1,r2,r3] = TDA(p1,e1,p2,e2,p3,e3);

% Print to User
fprintf('w1 => Red \nw2 => Blue \nw3 => Green \n')

% Plot Parameters
t = [1:12];
w1 = r1; 
w2 = r2; 
w3 = r3; 

figure (1)
stairs(t, w1,'r')
xlabel('t')
ylabel('w(t)')
axis([1,13,0,13])
title('Time Demand Analysis')
hold on

figure(1)
stairs(t, w2,'b')
hold on

figure(1)
stairs(t, w3,'g')
hold on

figure(1)
x = [0:13];
y = [-1:12];
plot(x, y, '--')