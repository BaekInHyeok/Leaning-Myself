import pygame
import random

#0.기본 초기화
pygame.init()

#화면 크기 설정
screen_width=480
screen_height=640
screen=pygame.display.set_mode((screen_width,screen_height))

#화면 타이틀 설정
pygame.display.set_caption("간단한 장애물 피하기 게임")

#FPS
clock=pygame.time.Clock()


#1.사용자 게임 초기화
#배경
background=pygame.image.load("C:\\Users\\USER\\Desktop\\대학 프로그래밍\\Python\\Game_BASIC\\background.png")

#캐릭터
character=pygame.image.load("C:\\Users\\USER\\Desktop\\대학 프로그래밍\\Python\\Game_BASIC\\character.png")
character_size=character.get_rect().size
character_width=character_size[0]
character_height=character_size[1]
character_x_pos=(screen_width/2)-(character_width/2)
character_y_pos=screen_height-character_height

#캐릭터 이동 위치
to_x=0
character_speed=10;

#장애물
obstacle=pygame.image.load("C:\\Users\\USER\\Desktop\\대학 프로그래밍\\Python\\Game_BASIC\\obstacle.png")
obstacle_size=obstacle.get_rect().size
obstacle_width=obstacle_size[0]
obstacle_height=obstacle_size[1]
obstacle_x_pos=random.randint(0,screen_width-obstacle_width)#장애물의 x값을 랜덤으로 정한다
obstacle_y_pos=0
obstacle_speed=10


running=True
while running:
    dt=clock.tick(30)

    #2.이벤트 처리(키보드,마우스)
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

        if event.type==pygame.KEYDOWN:
            if event.key==pygame.K_LEFT:
                to_x -=character_speed
            if event.key==pygame.K_RIGHT:
                to_x +=character_speed
        if event.type==pygame.KEYUP:
            if event.key==pygame.K_LEFT or event.key==pygame.K_RIGHT:
                to_x=0
    #3.게임 캐릭터 위치 정의
    character_x_pos += to_x
    if character_x_pos<0:
        character_x_pos=0
    elif character_x_pos>screen_width-character_width:
        character_x_pos=screen_width-character_width

    obstacle_y_pos += obstacle_speed
    if obstacle_y_pos>screen_height:
        obstacle_y_pos=0
        obstacle_x_pos=random.randint(0,screen_width-obstacle_width)#장애물의 x값을 랜덤으로 정한다

    #4.충돌 처리
    #캐릭터랑 장애물 각각의 사각형 판정을 가져와서 충돌여부를 판단한다
    character_rect=character.get_rect()
    character_rect.left=character_x_pos
    character_rect.top=character_y_pos

    obstacle_rect=obstacle.get_rect()
    obstacle_rect.left=obstacle_x_pos
    obstacle_rect.top=obstacle_y_pos

    if character_rect.colliderect(obstacle_rect):
        print("장애물 피하기 실패!")
        running=False

    #5.화면에 그리기
    screen.blit(background,(0,0))
    screen.blit(character,(character_x_pos,character_y_pos))
    screen.blit(obstacle,(obstacle_x_pos,obstacle_y_pos))

    pygame.display.update()

pygame.quit()