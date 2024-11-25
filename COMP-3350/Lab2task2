.data
A: .word 7, 42, 0, 27, 16, 8, 4, 15, 31, 45

.text
.globl main

main:
    # arguments for sort function
    la $a0, A    # address of array A
    li $a1, 10   # 10 elements in the array

    jal sort     # call sort function

    li $v0, 10   # exit system call
    syscall

# procedure to swap two elements in array v
swap:
    # save return address
    addi $sp, $sp, -4
    sw $ra, 0($sp)

    # load arguments
    lw $t0, 0($a0)      # v[k] is loaded from $a0 into $t0
    lw $t1, 4($a0)      # v[k+1] is loaded from $a0 into $t1

    # swap
    sw $t1, 0($a0)      # v[k+1] is stored into v[k]
    sw $t0, 4($a0)      # v[k] is stored into v[k+1]

    # restore return address
    lw $ra, 0($sp)
    addi $sp, $sp, 4

    jr $ra              # return to caller

# procedure for insertion sort
sort:
    # saves return address
    addi $sp, $sp, -4
    sw $ra, 0($sp)

    li $t2, 0           # i = 0
outer_loop:
    bge $t2, $a1, sort_exit  # if i >= n: exit sort
    li $t3, 1           # j = i - 1
inner_loop:
    blt $t3, 0, inner_loop_exit   # if j < 0, end inner loop

    sll $t4, $t3, 2     # calculate v[j] offset
    add $t4, $a0, $t4   # calculate v[j] address

    lw $t5, ($t4)       # v[j] is loaded from $t4 into $t5
    lw $t6, 4($t4)      # v[j+1] is loaded from $t4 into $t6

    ble $t5, $t6, inner_loop_exit  # if v[j] <= v[j+1], end inner loop

    jal swap            # calls swap function
    sub $t3, $t3, 1     # j--
    j inner_loop

inner_loop_exit:
    addi $t2, $t2, 1    # i++
    j outer_loop

sort_exit:
    # restores return address
    lw $ra, 0($sp)
    addi $sp, $sp, 4

    jr $ra              # return to caller
