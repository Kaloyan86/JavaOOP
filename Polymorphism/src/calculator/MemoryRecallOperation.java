package calculator;

import java.util.Deque;

public class MemoryRecallOperation implements Operation {

    private Deque<Integer> memory;

    public MemoryRecallOperation(Deque<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {

    }

    @Override
    public int getResult() {
        return this.memory.pop();
    }

    @Override
    public boolean isCompleted() {
        return this.memory.size() > 0;
    }
}
