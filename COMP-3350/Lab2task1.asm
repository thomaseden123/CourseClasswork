.data
A: .word 21, 50, 63, 72, 0, 95, 11, 28, 4, 5, 16, 7  # values of A[12]

.text
.globl main

main:
    # initialize loop counter i
    li $t0, 1        # int i = 1

outer_loop:
    bge $t0, 12, sort_exit   # if i >= 12: exit sort

    # load v with A[i]
    la $t1, A         # base address of array A
    sll $t2, $t0, 2   # calculate A[i] offset
    add $t1, $t1, $t2 # calculate A[i] address
    lw $t3, 0($t1)    # load A[i] into $t3

    # initialize loop counter j
    move $t4, $t0     # j = i
    subi $t4, $t4, 1  # j--

inner_loop:
    blt $t4, $zero, inner_loop_exit  # if j < 0, exit the inner loop

    subi $t5, $t4, 1   # calculate A[j] offset
    sll $t5, $t5, 2    # multiply offset * 4
    add $t6, $t1, $t5  # calculate A[i] address

    lw $t7, 0($t6)     # A[j] is loaded from $t6 into $t7

    bge $t7, $t3, inner_loop_exit  # if A[j] >= v, exit the inner loop

    sw $t7, 4($t6)     # A[j] is stored into A[j+1]

    subi $t4, $t4, 1   # j--
    j inner_loop

inner_loop_exit:
    sw $t3, 4($t1)     # v is stored into A[j+1]

    addi $t0, $t0, 1   # i++
    j outer_loop

sort_exit:
    li $v0, 10         # exit system call
    syscall
